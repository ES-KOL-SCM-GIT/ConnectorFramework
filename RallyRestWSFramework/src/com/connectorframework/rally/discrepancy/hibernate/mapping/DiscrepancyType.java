/**
 * 
 */
package com.connectorframework.rally.discrepancy.hibernate.mapping;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

/**
 * @author suvonkar.dam
 *
 */
@XmlRootElement
@Entity
@Table(name = "discrepancy_type")
@ApiObject(description="This is a object which is used to store Discrepancy Type", name = "DiscrepancyType", group = "Rally Discrepancy WS")
public class DiscrepancyType implements Serializable{

	private static final long serialVersionUID = -5261329030706015013L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	@ApiObjectField(name = "id", description = "ID of Discrepancy Type ", required = false)
	private Long id;
	
	@Column(name = "name", nullable = false)
	@ApiObjectField(name = "name", description = "Name of Discrepancy Type ", required = true)
	private String name;
	
	@Column(name = "description", nullable = false)
	@ApiObjectField(name = "description", description = "Description of Discrepancy Type ", required = true)
	private String description;
	
	@Column(name = "target_audience", nullable = true)
	@ApiObjectField(name = "targetAudience", description = "Target audience of Discrepancy Type ", required = true)
	private String targetAudience;
	
		
	public DiscrepancyType() {
		super();
	}

	public DiscrepancyType(String name, String desc, String targetAudience) {
		super();
		this.name = name;
		this.description = desc;
		this.targetAudience = targetAudience;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTargetAudience() {
		return targetAudience;
	}

	public void setTargetAudience(String targetAudience) {
		this.targetAudience = targetAudience;
	}

	@Override
	public String toString() {
		return "DiscrepancyType [id=" + id + ", name=" + name + ", description=" + description + ", targetAudience=" + targetAudience
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((targetAudience == null) ? 0 : targetAudience.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DiscrepancyType other = (DiscrepancyType) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (targetAudience == null) {
			if (other.targetAudience != null)
				return false;
		} else if (!targetAudience.equals(other.targetAudience))
			return false;
		return true;
	}
	
	
	
}
