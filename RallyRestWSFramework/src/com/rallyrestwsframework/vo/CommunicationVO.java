/**
 * 
 */
package com.rallyrestwsframework.vo;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.JsonElement;

/**
 * This is a object which is used for the data communication
 * @author Administrator
 *
 */
@XmlRootElement
public class CommunicationVO implements Serializable{
	
	
	private static final long serialVersionUID = -7181370482506216021L;

	/*This property is used to get the information of Query Request Type*/
	private String queryReqType;
	
	/*This property is used to get the information of Query Request Fetch*/
	private String qyeryReqFetch;
	
	/*This property is used to send the response */
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
	 * @return the qyeryReqFetch
	 */
	public String getQyeryReqFetch() {
		return qyeryReqFetch;
	}

	/**
	 * @param qyeryReqFetch the qyeryReqFetch to set
	 */
	public void setQyeryReqFetch(String qyeryReqFetch) {
		this.qyeryReqFetch = qyeryReqFetch;
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
