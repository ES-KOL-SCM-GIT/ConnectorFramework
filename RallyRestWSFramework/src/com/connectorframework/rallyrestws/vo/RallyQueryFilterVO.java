/**
 * 
 */
package com.connectorframework.rallyrestws.vo;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

/**
 * @author Administrator
 *
 */
@XmlRootElement
@ApiObject(description="This is a object which is used for Query Filtering.", name = "RallyQueryFilterVO")
public class RallyQueryFilterVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2532514234585127597L;
	
	@ApiObjectField(name = "field", description = "This property is used to set the field value of Rally Query Filter", required = true, order = 1)
	private String field;
	
	@ApiObjectField(name = "Operator", description = "This property is used to set the Operator value of Rally Query Filter", required = true, order = 2)
	private String operator;
	
	@ApiObjectField(name = "value", description = "This property is used to set the Value of Rally Query Filter", required = true, order = 3)
	private String value;
	
	/**
	 * @return the field
	 */
	public String getField() {
		return field;
	}

	/**
	 * @param field the field to set
	 */
	public void setField(String field) {
		this.field = field;
	}

	
	/**
	 * @return the operator
	 */
	public String getOperator() {
		return operator;
	}

	/**
	 * @param operator the operator to set
	 */
	public void setOperator(String operator) {
		this.operator = operator;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}
	

}
