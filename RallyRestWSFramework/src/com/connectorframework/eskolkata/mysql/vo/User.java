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
@ApiObject(description="This is a object which is used for the data of User", name = "User", group = "ES Kolkata MySQL")
public class User implements Serializable{
	
	private static final long serialVersionUID = 8617510089697022699L;
	
	@ApiObjectField(name = "userName", description = "User Name", required = false)
	private String userName;
	
	@ApiObjectField(name = "userId", description = "User Id", required = false)
	private String userId;
	
	@ApiObjectField(name = "emailId", description = "Email Address", required = false)
	private String emailId;
	
	@ApiObjectField(name = "roles", description = "List of Roles", required = false)
	private List<Role> roles;
	
	
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "User [userName=" + userName + ", userId=" + userId + ", emailId=" + emailId + ", roles=" + roles + "]";
	}

}
