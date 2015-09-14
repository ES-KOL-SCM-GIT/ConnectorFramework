/**
 * 
 */
package com.connectorframework.rallyrestws.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

/**
 * @author Administrator
 *
 */
@XmlRootElement
@ApiObject(description="<p>This is a object which is used to create Relation between filters.</p>"
		+ "<br/><p>Example:</p>"
		+ "<p>If required a filter like </p> "
		+ "<p>((State = Fixed) AND (Priority = &quot;Resolve Immediately&quot;))</p>"
		+ "<p> then need to construct a JSON object like </p>"
		+ "<p> {&quot;queryFilters&quot;:[{&quot;field&quot;:&quot;State&quot;,&quot;operator&quot;:&quot;=&quot;,&quot;value&quot;:&quot;Fixed&quot;},{&quot;field&quot;:&quot;Priority&quot;,&quot;operator&quot;:&quot;=&quot;,&quot;value&quot;:&quot;Resolve Immediately&quot;}],&quot;relationType&quot;:true,&quot;relations&quot;:[]}</p>",
		name = "Relation")
public class Relation implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6244441220476250398L;
	
	@ApiObjectField(name = "queryFilters", description = "This property is used to set the query filters which have a realtionship", required = true)
	private List<RallyQueryFilterVO> queryFilters = new ArrayList<RallyQueryFilterVO>();
	
	@ApiObjectField(name = "relationType", description = "This property is used to set the Relation Type of Rally Query Filter", required = true,  allowedvalues = "false for OR , true for AND")
	private boolean relationType;

	@ApiObjectField(name = "relations", description = "This property is used to set the relations which have a realtionship", required = false)
	private List<Relation> relations = new ArrayList<Relation>();
	
	
	/**
	 * @return the queryFilters
	 */
	public List<RallyQueryFilterVO> getQueryFilters() {
		return queryFilters;
	}

	/**
	 * @param queryFilters the queryFilters to set
	 */
	public void setQueryFilters(List<RallyQueryFilterVO> queryFilters) {
		this.queryFilters = queryFilters;
	}

	/**
	 * @return the relationType
	 */
	public boolean isRelationType() {
		return relationType;
	}

	/**
	 * @param relationType the relationType to set
	 */
	public void setRelationType(boolean relationType) {
		this.relationType = relationType;
	}

	/**
	 * @return the relations
	 */
	public List<Relation> getRelations() {
		return relations;
	}

	/**
	 * @param relations the relations to set
	 */
	public void setRelations(List<Relation> relations) {
		this.relations = relations;
	}
	
	

}
