/**
 * 
 */
package com.connectorframework.rally.discrepancy.provider;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.jsondoc.core.annotation.Api;
import org.jsondoc.core.annotation.ApiBodyObject;
import org.jsondoc.core.annotation.ApiMethod;
import org.jsondoc.core.annotation.ApiQueryParam;
import org.jsondoc.core.annotation.ApiResponseObject;
import org.jsondoc.core.pojo.ApiVerb;

import com.connectorframework.rally.discrepancy.exception.NoSuchDiscrepancyReport;
import com.connectorframework.rally.discrepancy.exception.NoSuchDiscrepancyType;
import com.connectorframework.rally.discrepancy.hibernate.mapping.DiscrepancyReport;
import com.connectorframework.rally.discrepancy.hibernate.mapping.DiscrepancyType;
import com.connectorframework.rally.discrepancy.service.DiscrepancyService;
import com.connectorframework.rally.discrepancy.service.DiscrepancyServiceImpl;
import com.google.gson.Gson;



/**
 * This is the interface of the Web service Provider
 * @author Suvonkar Dam
 *
 */
@Path("/discrepancy")
@Api(name = "Rally Discrepancy Web Service", description = "This is the interface of the Web service Provider of Rally Discrepancy", group = "Rally Discrepancy WS")
public class DiscrepancyProvider {
	
	final static Logger logger = Logger.getLogger(DiscrepancyProvider.class);
	
	final DiscrepancyService discrepancyService = new DiscrepancyServiceImpl(); 
	
	@ApiMethod(
			path = "/discrepancy/getAllDiscrepancyTypes",
			verb = ApiVerb.GET, 
			description = "Get All Discrepancy Types",
			produces = {MediaType.APPLICATION_JSON}
			)
	@GET
    @Path("/getAllDiscrepancyTypes")
    @Produces(MediaType.APPLICATION_JSON)
	public @ApiResponseObject List<DiscrepancyType> getAllDiscrepancyTypes(){
		logger.info("Starting get Discrepancy Types...");
		final List<DiscrepancyType> discrepancyTypes = discrepancyService.getDiscrepancyTypes();
		logger.info("Ended fetch Discrepancy Types...");
		if(logger.isDebugEnabled()){
			logger.debug("discrepancyTypes : " + discrepancyTypes);
		}
		return discrepancyTypes;
	}
	
	
	@ApiMethod(
			path = "/discrepancy/getDiscrepancyType",
			verb = ApiVerb.GET, 
			description = "Get Discrepancy Type based on provided id",
			produces = {MediaType.APPLICATION_JSON}
			)
	@GET
    @Path("/getDiscrepancyType")
    @Produces(MediaType.APPLICATION_JSON)
    public @ApiResponseObject String getDiscrepancyType(@ApiQueryParam(name="id", description="id of the Discrepancy Type") @QueryParam("id") Long id){
		logger.info("Starting get Discrepancy Type for id : " + id);
		DiscrepancyType discrepancyType = new DiscrepancyType();
		try {
			discrepancyType = discrepancyService.getDiscrepancyType(id);
		
			logger.info("Ended get Discrepancy Type for id : " + id);
			if(logger.isDebugEnabled()){
				logger.debug("for id : " + id + "discrepancyTypes : " + discrepancyType);
			}
		} catch (NoSuchDiscrepancyType e) {
			logger.error("No Such Discrepancy Type for id : " + id  , e);
		}
		return new Gson().toJson(discrepancyType);
	}


	@ApiMethod(
			path = "/discrepancy/deleteDiscrepancyType",
			verb = ApiVerb.DELETE, 
			description = "Delete Discrepancy Type based on provided id",
			produces = {MediaType.TEXT_PLAIN}
			)
	@DELETE
    @Path("/deleteDiscrepancyType")
	@Produces(MediaType.TEXT_PLAIN)
    public @ApiResponseObject String deleteDiscrepancyType(@ApiQueryParam(name="id", description="id of the Discrepancy Type") @QueryParam("id") Long id) {
		logger.info("Starting deleting Discrepancy Type for id : " + id);
		
		String message = "";
		
		try {
			discrepancyService.deleteDiscrepancyType(id);
			message = "Successfully deleted Discrepancy Type with id : " + id;
		} catch (NoSuchDiscrepancyType e) {
			logger.error("No Such Discrepancy Type for id : " + id  , e);
			message = "No Such Discrepancy Type for id : " + id;
		}
		
		logger.info("Ended deleting Discrepancy Type for id : " + id);
		
		return message;
		
	}

	@ApiMethod(
			path = "/discrepancy/saveDiscrepancyType",
			verb = ApiVerb.POST, 
			description = "Save Discrepancy Type",
			produces = {MediaType.TEXT_PLAIN},
			consumes = {MediaType.APPLICATION_JSON}
			)
	@POST
    @Path("/saveDiscrepancyType")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
    public @ApiResponseObject String saveDiscrepancyType(@ApiBodyObject DiscrepancyType discrepancyType){
		logger.info("Starting saving Discrepancy Type : " + discrepancyType);
		
		long discrepancyTypeId = discrepancyService.saveDiscrepancyType(discrepancyType);
		
		logger.info("End saving Discrepancy Type : " + discrepancyType);
		
		return "New Discrepancy Type added. Id is : " + discrepancyTypeId;
		
	}
	
	@ApiMethod(
			path = "/discrepancy/getAllDiscrepancrReports",
			verb = ApiVerb.GET, 
			description = "Get All Discrepancy Reports",
			produces = {MediaType.APPLICATION_JSON}
			)
	@GET
    @Path("/getAllDiscrepancrReports")
    @Produces(MediaType.APPLICATION_JSON)
	public @ApiResponseObject List<DiscrepancyReport> getAllDiscrepancrReports(){
		logger.info("Starting get Discrepancy Reports...");
		final List<DiscrepancyReport> discrepancyReports = discrepancyService.getDiscrepancrReports();
		logger.info("Ended fetch Discrepancy Reports...");
		if(logger.isDebugEnabled()){
			logger.debug("discrepancyReports : " + discrepancyReports);
		}
		return discrepancyReports;
	}
	
	@ApiMethod(
			path = "/discrepancy/getDiscrepancyReport",
			verb = ApiVerb.GET, 
			description = "Get Discrepancy Report based on provided id",
			produces = {MediaType.APPLICATION_JSON}
			)
	@GET
    @Path("/getDiscrepancyReport")
    @Produces(MediaType.APPLICATION_JSON)
    public @ApiResponseObject String getDiscrepancyReport(@ApiQueryParam(name="id", description="id of the Discrepancy Report") @QueryParam("id") Long id){
		logger.info("Starting get Discrepancy Report for id : " + id);
		DiscrepancyReport discrepancyReport = new DiscrepancyReport();
		try {
			discrepancyReport = discrepancyService.getDiscrepancyReport(id);
		
			logger.info("Ended get Discrepancy Report for id : " + id);
			if(logger.isDebugEnabled()){
				logger.debug("for id : " + id + "discrepancyReport : " + discrepancyReport);
			}
		} catch (NoSuchDiscrepancyReport e) {
			logger.error("No Such Discrepancy Report for id : " + id  , e);
		}
		return new Gson().toJson(discrepancyReport);
	}
	
	@ApiMethod(
			path = "/discrepancy/getDiscrepancyReportbyTeamAndDate",
			verb = ApiVerb.GET, 
			description = "Get Discrepancy Report based on provided team name and date",
			produces = {MediaType.APPLICATION_JSON}
			)
	@GET
    @Path("/getDiscrepancyReportbyTeamAndDate")
    @Produces(MediaType.APPLICATION_JSON)
    public @ApiResponseObject List<DiscrepancyReport> getDiscrepancyReportbyTeamAndDate(@ApiQueryParam(name="teamName", description="Team Name of the Discrepancy Report") 
    																   @QueryParam("teamName") String teamName,
    																   @ApiQueryParam(name="date", description="Date of the Discrepancy Report", format="MM/dd/yyyy") 
	   																   @QueryParam("date") String date){
		
		logger.info("Starting get Discrepancy Report for teamName : " + teamName + " and date : " + date);
		
		List<DiscrepancyReport> discrepancyReports = new ArrayList<DiscrepancyReport>();
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
			
			discrepancyReports = discrepancyService.getDiscrepancyReport(teamName, sdf.parse(date));
		
			logger.info("Ending get Discrepancy Report for teamName : " + teamName + " and date : " + date);
			
			
		} catch (NoSuchDiscrepancyReport e) {
			logger.error("No Such Discrepancy Report for team name : " + teamName + " and date : " + date  , e);
		} catch (ParseException e) {
			logger.error("Date ParseException for team name : " + teamName + " and date : " + date  , e);
		}
		return discrepancyReports;
	}
	
	@ApiMethod(
			path = "/discrepancy/getDiscrepancyReportbyDate",
			verb = ApiVerb.GET, 
			description = "Get Discrepancy Report based on provided date",
			produces = {MediaType.APPLICATION_JSON}
			)
	@GET
    @Path("/getDiscrepancyReportbyDate")
    @Produces(MediaType.APPLICATION_JSON)
    public @ApiResponseObject List<DiscrepancyReport> getDiscrepancyReportbyDate(@ApiQueryParam(name="date", description="Date of the Discrepancy Report", format="MM/dd/yyyy") 
	   														    @QueryParam("date") String date){
		
		logger.info("Starting get Discrepancy Report for date : " + date);
		
		List<DiscrepancyReport> discrepancyReports = new ArrayList<DiscrepancyReport>();
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
			
			 discrepancyReports = discrepancyService.getDiscrepancyReport(sdf.parse(date));
		
			logger.info("Ending get Discrepancy Report for date : " + date);
			
			
		} catch (NoSuchDiscrepancyReport e) {
			logger.error("No Such Discrepancy Report for date : " + date  , e);
		} catch (ParseException e) {
			logger.error("Date ParseException for date : " + date  , e);
		}
		return discrepancyReports;
	}
	
	@ApiMethod(
			path = "/discrepancy/getEmptyTeamDiscrepancyReport",
			verb = ApiVerb.GET, 
			description = "Get Discrepancy Report based on provided date for Empty Team Name",
			produces = {MediaType.APPLICATION_JSON}
			)
	@GET
    @Path("/getEmptyTeamDiscrepancyReport")
    @Produces(MediaType.APPLICATION_JSON)
    public @ApiResponseObject List<DiscrepancyReport> getEmptyTeamDiscrepancyReport(@ApiQueryParam(name="date", description="Date of the Discrepancy Report", format="MM/dd/yyyy") 
	   														    @QueryParam("date") String date){
		
		logger.info("Starting get Discrepancy Report for date : " + date);
		
		List<DiscrepancyReport> discrepancyReports = new ArrayList<DiscrepancyReport>();
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
			
			discrepancyReports = discrepancyService.getEmptyTeamDiscrepancyReport(sdf.parse(date));
		
			logger.info("Ending get Discrepancy Report for date : " + date);
			
			
		} catch (NoSuchDiscrepancyReport e) {
			logger.error("No Such Discrepancy Report for date : " + date  , e);
		} catch (ParseException e) {
			logger.error("Date ParseException for date : " + date  , e);
		}
		return discrepancyReports;
	}
	
	@ApiMethod(
			path = "/discrepancy/saveDiscrepancyReport",
			verb = ApiVerb.POST, 
			description = "Save Discrepancy Report",
			produces = {MediaType.TEXT_PLAIN},
			consumes = {MediaType.APPLICATION_JSON}
			)
	@POST
    @Path("/saveDiscrepancyReport")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
    public @ApiResponseObject String saveDiscrepancyReport(@ApiBodyObject DiscrepancyReport discrepancyReport){
		logger.info("Starting saving Discrepancy Report : " + discrepancyReport);
		
		long discrepancyReportId = discrepancyService.saveDiscrepancyReport(discrepancyReport);
		
		logger.info("End saving Discrepancy Report : " + discrepancyReport);
		
		return "New Discrepancy Report added. Id is : " + discrepancyReportId;
		
	}
	
	@ApiMethod(
			path = "/discrepancy/saveListOfDiscrepancyReports",
			verb = ApiVerb.POST, 
			description = "Save List of Discrepancy Report",
			produces = {MediaType.TEXT_PLAIN},
			consumes = {MediaType.APPLICATION_JSON}
			)
	@POST
    @Path("/saveListOfDiscrepancyReports")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
    public @ApiResponseObject String saveListOfDiscrepancyReports(@ApiBodyObject List<DiscrepancyReport> discrepancyReports){
		logger.info("Starting saving Discrepancy Report : " + discrepancyReports);
		
		discrepancyService.saveDiscrepancyReports(discrepancyReports);;
		
		logger.info("End saving Discrepancy Report : " + discrepancyReports);
		
		return "Total number of discrepancy report saved : " + discrepancyReports.size();
	}

	@ApiMethod(
			path = "/discrepancy/deleteDiscrepancyReport",
			verb = ApiVerb.DELETE, 
			description = "Delete Discrepancy Report based on date",
			produces = {MediaType.TEXT_PLAIN}
			)
	@DELETE
    @Path("/deleteDiscrepancyReport")
	@Produces(MediaType.TEXT_PLAIN)
    public @ApiResponseObject String deleteDiscrepancyReport(@ApiQueryParam(name="date", description="Date of the Discrepancy Report", format="MM/dd/yyyy") 
	    													 @QueryParam("date") String date) {
		logger.info("Starting deleting Discrepancy Report for date : " + date);
		
		String message = "";
		
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
			discrepancyService.deleteDiscrepancyReport(sdf.parse(date));
			message = "Successfully deleted Discrepancy Report with date : " + date;
		} catch (ParseException e) {
			logger.error("Date ParseException to delete Discrepancy Report for date : " + date  , e);
			message = "Date ParseException to delete Discrepancy Report for date : " + date;
		}
		
		logger.info("Ended deleting Discrepancy Report for date : " + date);
		
		return message;
		
	}
}
