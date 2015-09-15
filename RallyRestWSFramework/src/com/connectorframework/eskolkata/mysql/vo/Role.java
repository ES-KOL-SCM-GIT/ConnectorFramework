/**
 * 
 */
package com.connectorframework.eskolkata.mysql.vo;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

/**
 * @author suvonkar.dam
 *
 */
@XmlRootElement
@ApiObject(description="This is a object which is used for the data of User", name = "Role", group = "ES Kolkata MySQL")
public class Role implements Serializable{

	private static final long serialVersionUID = -1348049351898969497L;

	@ApiObjectField(name = "roleName", description = "Role Name", required = false)
	private String roleName;

	@ApiObjectField(name = "roleId", description = "Role Id", required = false)
	private String roleId;
	
	@ApiObjectField(name = "rallyGroup", description = "Role Group information. 1 for Rally Group and 0 for non Rally Group.", required = false)
	private String rallyGroup;

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	
	public String getRallyGroup() {
		return rallyGroup;
	}

	public void setRallyGroup(String rallyGroup) {
		this.rallyGroup = rallyGroup;
	}

	@Override
	public String toString() {
		return "Role [roleName=" + roleName + ", roleId=" + roleId + ", rallyGroup=" + rallyGroup + "]";
	}
	
	
}
