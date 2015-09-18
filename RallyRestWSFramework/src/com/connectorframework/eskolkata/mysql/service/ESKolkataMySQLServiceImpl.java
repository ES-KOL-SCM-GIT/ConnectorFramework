/**
 * 
 */
package com.connectorframework.eskolkata.mysql.service;

import java.sql.SQLException;
import java.util.List;

import com.connectorframework.eskolkata.mysql.dao.ESKolkataMySQLDAO;
import com.connectorframework.eskolkata.mysql.vo.User;

/**
 * @author suvonkar.dam
 *
 */
public class ESKolkataMySQLServiceImpl implements ESKolkataMySQLService {

	/* (non-Javadoc)
	 * @see com.connectorframework.eskolkata.mysql.service.ESKolkataMySQLService#getMembersbyTeamName(java.lang.String)
	 */
	@Override
	public List<User> getMembersbyTeamName(String teamName) throws ClassNotFoundException, SQLException {
		return new ESKolkataMySQLDAO().getMembersbyTeamName(teamName);
	}

}
