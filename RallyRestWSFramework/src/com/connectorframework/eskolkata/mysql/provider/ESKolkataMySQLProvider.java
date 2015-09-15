/**
 * 
 */
package com.connectorframework.eskolkata.mysql.provider;

import java.net.URISyntaxException;
import java.security.GeneralSecurityException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.jsondoc.core.annotation.Api;
import org.jsondoc.core.annotation.ApiBodyObject;
import org.jsondoc.core.annotation.ApiMethod;
import org.jsondoc.core.annotation.ApiResponseObject;
import org.jsondoc.core.pojo.ApiVerb;

import com.connectorframework.eskolkata.mysql.service.ESKolkataMySQLService;
import com.connectorframework.eskolkata.mysql.service.ESKolkataMySQLServiceImpl;
import com.connectorframework.eskolkata.mysql.vo.ESKolMySQLCommunicationVO;
import com.connectorframework.eskolkata.mysql.vo.User;

/**
 * This is the interface of the Web service Provider
 * 
 * @author Suvonkar Dam
 *
 */
@Path("/eskolkata/mysql")
@Api(name = "ES Kolkata My SQL Web Service", description = "This is the interface of the Google Drive Web service Provider", group = "ES Kolkata MySQL")
public class ESKolkataMySQLProvider {

	final static Logger logger = Logger.getLogger(ESKolkataMySQLProvider.class);
	
	final ESKolkataMySQLService esKolkataMySQLService = new ESKolkataMySQLServiceImpl();
	
	@ApiMethod(path = "/eskolkata/mysql/getMembersbyTeamName", 
			   verb = ApiVerb.POST, 
			   description = "Check Query Filter", 
			   consumes = { MediaType.APPLICATION_JSON }, 
			   produces = { MediaType.APPLICATION_JSON })
	@POST
	@Path("/getMembersbyTeamName")
	public @ApiResponseObject ESKolMySQLCommunicationVO getMembersbyTeamName(@ApiBodyObject ESKolMySQLCommunicationVO comVO) throws GeneralSecurityException, URISyntaxException {
		logger.info("Starting to get the members by team name...");
		ESKolMySQLCommunicationVO eSKolMySQLCommunicationVO = new ESKolMySQLCommunicationVO();
		List<User> users = new ArrayList<User>();
		
		try {
			eSKolMySQLCommunicationVO.setTeamName(comVO.getTeamName());
			users = esKolkataMySQLService.getMembersbyTeamName(comVO.getTeamName());
			eSKolMySQLCommunicationVO.setUsers(users);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		logger.info("Ended to get the members by team name...");
		return eSKolMySQLCommunicationVO;
	}


}
