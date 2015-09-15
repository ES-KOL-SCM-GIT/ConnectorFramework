/**
 * 
 */
package com.connectorframework.eskolkata.mysql.service;

import java.sql.SQLException;
import java.util.List;

import com.connectorframework.eskolkata.mysql.vo.User;

/**
 * @author suvonkar.dam
 *
 */
public interface ESKolkataMySQLService {
	
	/**
	 * Get the team members by team name
	 * @param teamName
	 * @return
	 */
	List<User> getMembersbyTeamName(String teamName) throws ClassNotFoundException, SQLException;
}
