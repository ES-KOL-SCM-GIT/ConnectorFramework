/**
 * 
 */
package com.connectorframework.eskolkata.mysql.vo;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

/**
 * This is a object which is used for the data communication
 * @author Administrator
 *
 */
@XmlRootElement
@ApiObject(description="This is a object which is used for the data communication", name = "ESKolMySQLCommunicationVO", group = "ES Kolkata MySQL")
public class ESKolMySQLCommunicationVO implements Serializable{
	
	private static final long serialVersionUID = -4217668384497150284L;

	@ApiObjectField(name = "teamName", description = "The team name", required = false)
	private String teamName;
	
	@ApiObjectField(name = "users", description = "The list of user", required = false)
	private List<User> users;

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "CommunicationVO [teamName=" + teamName + ", users=" + users + "]";
	}
}
