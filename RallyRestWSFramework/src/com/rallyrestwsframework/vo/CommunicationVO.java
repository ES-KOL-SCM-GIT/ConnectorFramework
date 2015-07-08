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
