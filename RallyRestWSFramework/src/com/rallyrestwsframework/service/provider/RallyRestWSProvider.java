/**
 * 
 */
package com.rallyrestwsframework.service.provider;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.rallydev.rest.RallyRestApi;
import com.rallydev.rest.request.QueryRequest;
import com.rallydev.rest.response.QueryResponse;
import com.rallydev.rest.util.Fetch;
import com.rallyrestwsframework.propertyreader.PropertyReader;
import com.rallyrestwsframework.vo.CommunicationVO;



/**
 * This is the interface of the Web service Provider
 * @author Suvonkar Dam
 *
 */
@Path("/rallyrestws")
public class RallyRestWSProvider {
	
	final static Logger logger = Logger.getLogger(RallyRestWSProvider.class);
	
	/**
	 * Query Rally to get data
	 * @return
	 * @throws IllegalAccessException 
	 * @throws URISyntaxException 
	 * @throws Exception 
	 */
	@POST
    @Path("/queryrally")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String queryRally(CommunicationVO communicationVO) throws IOException, IllegalAccessException, URISyntaxException{
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
			qRequest.setLimit(Integer.MAX_VALUE);
			
			if(communicationVO.getQyeryReqFetch() != null && !"".equals(communicationVO.getQyeryReqFetch())){
				qRequest.setFetch(new Fetch(StringUtils.join(communicationVO.getQyeryReqFetch().split(",") , ",")));
				logger.debug("Query Request Fetch  : " + StringUtils.join(communicationVO.getQyeryReqFetch().split(",") , ","));
			}
			
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
	};
}
