/**
 * 
 */
package com.connectorframework.eskolkata.mysql.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.connectorframework.eskolkata.mysql.vo.Role;
import com.connectorframework.eskolkata.mysql.vo.User;
import com.connectorframework.propertyreader.PropertyReader;

/**
 * @author suvonkar.dam
 *
 */
public class ESKolkataMySQLDAO {
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = PropertyReader.properties.getProperty("es.kolkata.mysql.url");

	// Database credentials
	static final String USER = PropertyReader.properties.getProperty("es.kolkata.mysql.username");
	static final String PASS = PropertyReader.properties.getProperty("es.kolkata.mysql.password");

	public List<User> getMembersbyTeamName(String teamName) throws ClassNotFoundException, SQLException {
		Connection connection = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		List<User> users = new ArrayList<User>();
		try {
			connection = getConnection();
			StringBuffer sqlSb = new StringBuffer();
			sqlSb.append("SELECT e.EmployeeId AS 'empId', e.EmployeeName AS 'empName', e.Email AS 'empEmail' ")
					.append("FROM employee e, emp_view ev, groups gr ")
					.append("WHERE e.EmployeeId = ev.employeeid ")
					.append("AND ev.groupid = gr.GroupId ")
					.append("AND gr.GroupName = ? ")
					.append("AND gr.IsActive = 1 ")
					.append("AND e.IsActive = 1");

			stmt = connection.prepareStatement(sqlSb.toString());

			stmt.setString(1, teamName.trim());

			rs = stmt.executeQuery();

			while (rs.next()) {
				User user = new User();
				
				user.setUserId(rs.getString("empId"));
				user.setUserName(rs.getString("empName"));
				user.setEmailId(rs.getString("empEmail"));
				
				user.setRoles(getRolesbyEmpId(rs.getString("empId")));
				
				users.add(user);
			}
		} finally {
			close(rs, stmt, connection);
		}
		return users;
	}

	/**
	 * Get the role list by employee id
	 * @param string
	 * @return
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	private List<Role> getRolesbyEmpId(String empId) throws ClassNotFoundException, SQLException {
		Connection connection = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		List<Role> roles = new ArrayList<Role>();
		try {
			connection = getConnection();
			StringBuffer sqlSb = new StringBuffer();
			sqlSb.append("SELECT gr.GroupId as 'groupId', gr.GroupName as 'roupName', gr.IsRallyGroup as 'rallyGroup' ")
					.append("FROM emp_view ev, groups gr ")
					.append("WHERE ev.employeeid = ? ")
					.append("AND ev.groupid = gr.GroupId ")
					.append("AND gr.IsActive = 1 ");

			stmt = connection.prepareStatement(sqlSb.toString());

			stmt.setString(1, empId.trim());

			rs = stmt.executeQuery();

			while (rs.next()) {
				Role role = new Role();
				
				role.setRoleId(rs.getString("groupId"));
				role.setRoleName(rs.getString("roupName"));
				role.setRallyGroup(rs.getString("rallyGroup"));
				
				roles.add(role);
			}
		} finally {
			close(rs, stmt, connection);
		}
		return roles;
	}

	/**
	 * Get the DB connection
	 * 
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	private Connection getConnection() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
		return con;
	}

	/**
	 * Close the resultset, statement and connection
	 * 
	 * @param stmt
	 * @param con
	 * @throws SQLException
	 */
	private void close(ResultSet rs, PreparedStatement stmt, Connection con) throws SQLException {
		if (rs != null) {
			rs.close();
		}
		if (stmt != null) {
			stmt.close();
		}
		if (con != null) {
			con.close();
		}
	}
}
