/**
 * 
 */
package com.rallyrestwsframework.vo;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.apache.http.NameValuePair;
import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import com.google.gson.JsonElement;

/**
 * This is a object which is used for the data communication
 * @author Administrator
 *
 */
@XmlRootElement
@ApiObject(description="This is a object which is used for the data communication", name = "CommunicationVO")
public class CommunicationVO implements Serializable{
	
	
	private static final long serialVersionUID = -7181370482506216021L;

	@ApiObjectField(name = "queryReqType", description = "This property is used to get the information of Query Request Type", required = true)
	private String queryReqType;
	
	@ApiObjectField(name = "queryReqFetch", description = "This property is used to get the information of Query Request Fetch. Fields should be comma separated.")
	private String queryReqFetch;
	
	@ApiObjectField(name = "queryReqLimit", description = "This property is used to set the limit of Query Request")
	private int queryReqLimit;
	
	@ApiObjectField(name = "queryReqOrder", description = "This property is used to set the Order of Query Request")
	private String queryReqOrder;
	
	@ApiObjectField(name = "queryReqPageSize", description = "This property is used to set the Page Size of Query Request")
	private int queryReqPageSize;
	
	@ApiObjectField(name = "queryReqProjectRef", description = "This property is used to set the Project Reference of Query Request")
	private String queryReqProjectRef;
	
	@ApiObjectField(name = "queryReqWorkspaceRef", description = "This property is used to set the Workspace Reference of Query Request")
	private String queryReqWorkspaceRef;
	
	@ApiObjectField(name = "queryReqParams", description = "This property is used to set the list of additional parameters included in this request")
	private List<NameValuePair> queryReqParams;
	
	@ApiObjectField(name = "queryReqScopedDown", description = "<p>If a project has been specified, set whether to include matching objects in child projects in the result set.</p> "
			+ "<p> Defaults to true.</p>")
	private boolean queryReqScopedDown = true;
		
    @ApiObjectField(name = "queryReqScopedUp", description = "<p>If a project has been specified, set whether to include matching objects in parent projects in the result set.</p> "
    		+ "<p>Defaults to false. <p/>")
	private boolean queryReqScopedUp = false;
	
	@ApiObjectField(name = "queryReqFilter", description = "This property is used to set the Filter of Query Request")
	private Relation queryReqFilter;
	
	//@ApiObjectField(name = "response", description = "This property is used to send the response", required = false)
	private JsonElement response;
	

	/**
	 * @return the queryReqType
	 */
	public String getQueryReqType() {
		return queryReqType;
	}

	/**
	 * @param queryReqType the queryReqType to set
	 */
	public void setQueryReqType(String queryReqType) {
		this.queryReqType = queryReqType;
	}

	
	/**
	 * @return the queryReqFetch
	 */
	public String getQueryReqFetch() {
		return queryReqFetch;
	}

	/**
	 * @param queryReqFetch the queryReqFetch to set
	 */
	public void setQueryReqFetch(String queryReqFetch) {
		this.queryReqFetch = queryReqFetch;
	}

	/**
	 * @return the queryReqLimit
	 */
	public int getQueryReqLimit() {
		return queryReqLimit;
	}

	/**
	 * @param queryReqLimit the queryReqLimit to set
	 */
	public void setQueryReqLimit(int queryReqLimit) {
		this.queryReqLimit = queryReqLimit;
	}

	/**
	 * @return the queryReqOrder
	 */
	public String getQueryReqOrder() {
		return queryReqOrder;
	}

	/**
	 * @param queryReqOrder the queryReqOrder to set
	 */
	public void setQueryReqOrder(String queryReqOrder) {
		this.queryReqOrder = queryReqOrder;
	}

	/**
	 * @return the queryReqPageSize
	 */
	public int getQueryReqPageSize() {
		return queryReqPageSize;
	}

	/**
	 * @param queryReqPageSize the queryReqPageSize to set
	 */
	public void setQueryReqPageSize(int queryReqPageSize) {
		this.queryReqPageSize = queryReqPageSize;
	}

	/**
	 * @return the queryReqProjectRef
	 */
	public String getQueryReqProjectRef() {
		return queryReqProjectRef;
	}

	/**
	 * @param queryReqProjectRef the queryReqProjectRef to set
	 */
	public void setQueryReqProjectRef(String queryReqProjectRef) {
		this.queryReqProjectRef = queryReqProjectRef;
	}

	/**
	 * @return the queryReqWorkspaceRef
	 */
	public String getQueryReqWorkspaceRef() {
		return queryReqWorkspaceRef;
	}

	/**
	 * @param queryReqWorkspaceRef the queryReqWorkspaceRef to set
	 */
	public void setQueryReqWorkspaceRef(String queryReqWorkspaceRef) {
		this.queryReqWorkspaceRef = queryReqWorkspaceRef;
	}

	/**
	 * @return the queryReqParams
	 */
	public List<NameValuePair> getQueryReqParams() {
		return queryReqParams;
	}

	/**
	 * @param queryReqParams the queryReqParams to set
	 */
	public void setQueryReqParams(List<NameValuePair> queryReqParams) {
		this.queryReqParams = queryReqParams;
	}
	
	/**
	 * @return the queryReqScopedDown
	 */
	public boolean isQueryReqScopedDown() {
		return queryReqScopedDown;
	}

	/**
	 * @param queryReqScopedDown the queryReqScopedDown to set
	 */
	public void setQueryReqScopedDown(boolean queryReqScopedDown) {
		this.queryReqScopedDown = queryReqScopedDown;
	}
	
	/**
	 * @return the queryReqScopedUp
	 */
	public boolean isQueryReqScopedUp() {
		return queryReqScopedUp;
	}

	/**
	 * @param queryReqScopedUp the queryReqScopedUp to set
	 */
	public void setQueryReqScopedUp(boolean queryReqScopedUp) {
		this.queryReqScopedUp = queryReqScopedUp;
	}

	/**
	 * @return the queryReqFilter
	 */
	public Relation getQueryReqFilter() {
		return queryReqFilter;
	}

	/**
	 * @param queryReqFilter the queryReqFilter to set
	 */
	public void setQueryReqFilter(Relation queryReqFilter) {
		this.queryReqFilter = queryReqFilter;
	}

	/**
	 * @return the response
	 */
	public JsonElement getResponse() {
		return response;
	}

	/**
	 * @param response the response to set
	 */
	public void setResponse(JsonElement response) {
		this.response = response;
	}

	

	
}
