/**
 * 
 */
package com.rallyrestwsframework.vo;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

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
	
	@ApiObjectField(name = "queryReqFetch", description = "This property is used to get the information of Query Request Fetch")
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
	
	@ApiObjectField(name = "queryReqFilters", description = "This property is used to set the Filters of Query Request")
	private Relation queryReqFilter;
	
	@ApiObjectField(name = "response", description = "This property is used to send the response")
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
