/**
 * 
 */
package com.connectorframework.rallyrestws.service.provider;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.NameValuePair;
import org.apache.log4j.Logger;
import org.jsondoc.core.annotation.Api;
import org.jsondoc.core.annotation.ApiBodyObject;
import org.jsondoc.core.annotation.ApiMethod;
import org.jsondoc.core.annotation.ApiResponseObject;
import org.jsondoc.core.pojo.ApiVerb;

import com.connectorframework.propertyreader.PropertyReader;
import com.connectorframework.rallyrestws.vo.CommunicationVO;
import com.connectorframework.rallyrestws.vo.RallyQueryFilterVO;
import com.connectorframework.rallyrestws.vo.Relation;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.rallydev.rest.RallyRestApi;
import com.rallydev.rest.request.QueryRequest;
import com.rallydev.rest.response.QueryResponse;
import com.rallydev.rest.util.Fetch;
import com.rallydev.rest.util.QueryFilter;



/**
 * This is the interface of the Web service Provider
 * @author Suvonkar Dam
 *
 */
@Path("/rallyrestws")
@Api(name = "Rally Rest Web Service", description = "This is the interface of the Web service Provider", group = "Rally Rest WS")
public class RallyRestWSProvider {
	
	final static Logger logger = Logger.getLogger(RallyRestWSProvider.class);
	
	@ApiMethod(
			path = "/rallyrestws/checkQueryFilter",
			verb = ApiVerb.POST, 
			description = "Check Query Filter",
			consumes = {MediaType.APPLICATION_JSON},
			produces = {MediaType.TEXT_PLAIN}
			)
	@POST
    @Path("/checkQueryFilter")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
	public @ApiResponseObject String checkQueryFilter(@ApiBodyObject Relation relation){
		logger.info("Starting Construct the Query Filter...");
		final QueryFilter filter = constructQueryFilter(relation, null);
		logger.info("Ended Construct the Query Filter...");
		logger.info("Constructed filter is : " + filter);
		return filter.toString();
	}
	
	
	/**
	 * Query Rally to get data
	 * @return
	 * @throws IllegalAccessException 
	 * @throws URISyntaxException 
	 * @throws Exception 
	 */
	@ApiMethod(
			path = "/rallyrestws/queryrally",
			verb = ApiVerb.POST, 
			description = "Query Rally to get data",
			consumes = {MediaType.APPLICATION_JSON},
			produces = {MediaType.APPLICATION_JSON}
			)
	@POST
    @Path("/queryrally")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public @ApiResponseObject String queryRally(@ApiBodyObject CommunicationVO communicationVO) throws IOException, IllegalAccessException, URISyntaxException{
		JsonElement responseJSONElmnt = null;
    	RallyRestApi rallyRestApi = null;
    	try {
    		logger.info("Starting Query...");
    		
    		final String rallyUrl = PropertyReader.properties.getProperty("rally.url");
    		logger.debug("Rally URL: " + rallyUrl);
    		
    		final String apiKey = PropertyReader.properties.getProperty("api.key");
    		rallyRestApi = new RallyRestApi(new URI(rallyUrl), apiKey);
    		
    		if(communicationVO.getQueryReqType() == null || "".equals(communicationVO.getQueryReqType())){
    			logger.error("Mandetory Query Request Type is not available");
    			throw new IllegalAccessException("Mandetory Query Request Type is not available");
    		}
    		
    		QueryRequest  qRequest = new QueryRequest(communicationVO.getQueryReqType());
    		
    		setQueryReqProps(qRequest, communicationVO);
			
			QueryResponse queryResponse = rallyRestApi.query(qRequest);
			
			if(queryResponse.wasSuccessful()){
				logger.info("Successfully query data.");
				responseJSONElmnt = queryResponse.getResults();
			}else{
				logger.error("Unable to query data.");
			}
    	} finally{
			if(rallyRestApi != null){
				logger.debug("Finally closing the connection.");
				rallyRestApi.close();
			}
		}
    	communicationVO.setResponse(responseJSONElmnt);
    	String response = new Gson().toJson(communicationVO);
    	logger.debug("Sending Data: " + response);
		return response;
	}

	/**
	 * Set the properties of the QueryRequest
	 * @param qRequest
	 * @param communicationVO
	 */
	private void setQueryReqProps(QueryRequest qRequest,
			CommunicationVO communicationVO) {
		
		final int requestLimit = communicationVO.getQueryReqLimit();
		if(requestLimit > 0){
			logger.info("Request limit is set to : " + requestLimit);
			qRequest.setLimit(requestLimit);
		}else{
			qRequest.setLimit(Integer.MAX_VALUE);
		}
		
		if(communicationVO.getQueryReqFetch() != null && !"".equals(communicationVO.getQueryReqFetch())){
			qRequest.setFetch(new Fetch(StringUtils.join(communicationVO.getQueryReqFetch().split(",") , ",")));
			logger.info("Query Request Fetch  : " + StringUtils.join(communicationVO.getQueryReqFetch().split(",") , ","));
		}
		
		if(communicationVO.getQueryReqOrder() != null && !"".equals(communicationVO.getQueryReqOrder())){
			qRequest.setOrder(communicationVO.getQueryReqOrder());
			logger.info("Request Order is set to : " + communicationVO.getQueryReqOrder());
		}
		
		final int pageSize = communicationVO.getQueryReqPageSize();
		if(pageSize > 0){
			qRequest.setPageSize(pageSize);
			logger.info("Request Page Size is set to : " + pageSize);
		}
		
		final String projRef = communicationVO.getQueryReqProjectRef();
		if(projRef != null && !"".equals(projRef)){
			qRequest.setProject(projRef);
			logger.info("Request Project reference is set to : " + projRef);
		}
		
		final String workspaceRef = communicationVO.getQueryReqWorkspaceRef();
		if(workspaceRef != null && !"".equals(workspaceRef)){
			qRequest.setWorkspace(workspaceRef);
			logger.info("Request Workspace reference is set to : " + workspaceRef);
		}
		
		final Relation filterVO = communicationVO.getQueryReqFilter();
		if(filterVO != null){
			QueryFilter filter = constructQueryFilter(filterVO, null);
			qRequest.setQueryFilter(filter);
			logger.info("Request Filter is set to : " + filter);
		}
		
		final List<NameValuePair> params = communicationVO.getQueryReqParams();
		if(params != null && !params.isEmpty()){
			qRequest.setParams(params);
		}
		
		final boolean scopeDown = communicationVO.isQueryReqScopedDown();
		if(!scopeDown){
			qRequest.setScopedDown(scopeDown);
		}
		
		final boolean scopeUp = communicationVO.isQueryReqScopedUp();
		if(scopeUp){
			qRequest.setScopedUp(scopeUp);
		}
	};
	

	/**
	 * Construct the Query Filter
	 * @param relation
	 * @return
	 */
	private static QueryFilter constructQueryFilter(Relation relation, QueryFilter filter) {
		if (!relation.getRelations().isEmpty()) {
			for (Relation r : relation.getRelations()) {
				if(filter == null){
					filter = constructQueryFilter(r, filter);
				}else{
					if(relation.isRelationType()){
						filter = filter.and(constructQueryFilter(r, null));
					}else{
						filter = filter.or(constructQueryFilter(r, null));
					}
				}
			}
		}else if(!relation.getQueryFilters().isEmpty()){
			if(relation.getQueryFilters().size() == 1){
				final RallyQueryFilterVO filterVO = relation.getQueryFilters().get(0);
				if(filter == null){
					filter = new QueryFilter(filterVO.getField(), filterVO.getOperator(), filterVO.getValue());
				}else{
					if(relation.isRelationType()){
						filter = filter.and(new QueryFilter(filterVO.getField(), filterVO.getOperator(), filterVO.getValue()));
						return filter;
					}else{
						filter = filter.or(new QueryFilter(filterVO.getField(), filterVO.getOperator(), filterVO.getValue()));
						return filter;
					}
				}
			}else{
				//List<QueryFilter> filters = new ArrayList<QueryFilter>();
				for(RallyQueryFilterVO filterVO : relation.getQueryFilters()){
					if(filter == null){
						filter = new QueryFilter(filterVO.getField(), filterVO.getOperator(), filterVO.getValue());
					}else{
						if(relation.isRelationType()){
							filter = filter.and(new QueryFilter(filterVO.getField(), filterVO.getOperator(), filterVO.getValue()));
						}else{
							filter = filter.or(new QueryFilter(filterVO.getField(), filterVO.getOperator(), filterVO.getValue()));
						}
					}
				}
				/*if(relation.isRelationType()){
					filter = filter.and(filters.toArray(new QueryFilter[filters.size()]));
				}else{
					filter = filter.or(filters.toArray(new QueryFilter[filters.size()]));
				}*/
				return filter;
			}
			
		}
		return filter;
	}
	
	/*public static void main(String[] args) {
		RallyQueryFilterVO r1 = new RallyQueryFilterVO();
		r1.setField("State");
		r1.setOperator("=");
		r1.setValue("Fixed");
		
		RallyQueryFilterVO r2 = new RallyQueryFilterVO();
		r2.setField("Priority");
		r2.setOperator("=");
		r2.setValue("Resolve Immediately");
		
		RallyQueryFilterVO r3 = new RallyQueryFilterVO();
		r3.setField("XYZ");
		r3.setOperator("<>");
		r3.setValue("ABC");
		
		RallyQueryFilterVO r4 = new RallyQueryFilterVO();
		r4.setField("MNP");
		r4.setOperator("!=");
		r4.setValue("RST");
		
		RallyQueryFilterVO r5 = new RallyQueryFilterVO();
		r5.setField("MNP");
		r5.setOperator("!=");
		r5.setValue("RST");
		
		Relation R1 = new Relation();
		R1.getQueryFilters().add(r1);
		R1.getQueryFilters().add(r2);
		R1.getQueryFilters().add(r5);
		R1.setRelationType(true);
		
		
		Relation R2 = new Relation();
		R2.getQueryFilters().add(r3);
		R2.getQueryFilters().add(r4);
		R2.setRelationType(false);
		
		Relation R3 = new Relation();
		R3.getRelations().add(R1);
		R3.getRelations().add(R2);
		R3.setRelationType(false);
		
		
		RallyQueryFilterVO r11 = new RallyQueryFilterVO();
		r11.setField("State");
		r11.setOperator("=");
		r11.setValue("Fixed");
		
		RallyQueryFilterVO r22 = new RallyQueryFilterVO();
		r22.setField("Priority");
		r22.setOperator("=");
		r22.setValue("Resolve Immediately");
		
		RallyQueryFilterVO r33 = new RallyQueryFilterVO();
		r33.setField("XYZ");
		r33.setOperator("<>");
		r33.setValue("ABC");
		
		RallyQueryFilterVO r44 = new RallyQueryFilterVO();
		r44.setField("MNP");
		r44.setOperator("!=");
		r44.setValue("RST");
		
		Relation R11 = new Relation();
		R11.getQueryFilters().add(r11);
		R11.getQueryFilters().add(r22);
		R11.setRelationType(true);
		
		
		Relation R22 = new Relation();
		R22.getQueryFilters().add(r33);
		R22.getQueryFilters().add(r44);
		R22.setRelationType(false);
		
		Relation R33 = new Relation();
		R33.getRelations().add(R11);
		R33.getRelations().add(R22);
		R33.setRelationType(false);
		
		Relation R = new Relation();
		R.getRelations().add(R3);
		R.getRelations().add(R33);
		R.setRelationType(true);
		
		System.out.println(new Gson().toJson(R));
		QueryFilter filter = constructQueryFilter(R, null);
		
		logger.info("Request Filter is set to : " + filter);
		
	}*/
}
