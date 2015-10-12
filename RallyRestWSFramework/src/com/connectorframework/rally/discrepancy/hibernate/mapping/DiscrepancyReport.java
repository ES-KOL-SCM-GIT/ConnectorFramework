/**
 * 
 */
package com.connectorframework.rally.discrepancy.hibernate.mapping;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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
@Table(name = "discrepancy_report")
@ApiObject(description="This is a object which is used to store Discrepancy Report", name = "DiscrepancyReport", group = "Rally Discrepancy WS")
public class DiscrepancyReport implements Serializable{

	
	private static final long serialVersionUID = 5836693266585344496L;

	
	@ApiObjectField(name = "id", description = "ID of Discrepancy Report ", required = false)
	private Long id;

	@ApiObjectField(name = "discType", description = "Type of Discrepancy Report ", required = false)
	private DiscrepancyType discType;

	@ApiObjectField(name = "formattedID", description = "Formatted ID of Discrepancy Report ", required = false)
	private String formattedID;
	
	@ApiObjectField(name = "artifactName", description = "Artifact Name of Discrepancy Report ", required = false)
	private String artifactName;
	
	@ApiObjectField(name = "artifactRef", description = "Artifact Ref of Discrepancy Report ", required = false)
	private String artifactRef;
	
	@ApiObjectField(name = "teamName", description = "Team Name of Discrepancy Report ", required = false)
	private String teamName;
	
	@ApiObjectField(name = "artifactOwner", description = "Artifact Owner of Discrepancy Report ", required = false)
	private String artifactOwner;
	
	@ApiObjectField(name = "productOwner", description = "Product Owner of Discrepancy Report ", required = false)
	private String productOwner;
	
	@ApiObjectField(name = "date", description = "Date of Discrepancy Report ", required = false)
	private Date date;
	

	public DiscrepancyReport() {
		super();
	}


	public DiscrepancyReport(DiscrepancyType discType, String formattedID, String artifactName,
			String artifactRef, String teamName, String artifactOwner, String productOwner, Date date) {
		super();
		this.discType = discType;
		this.formattedID = formattedID;
		this.artifactName = artifactName;
		this.artifactRef = artifactRef;
		this.teamName = teamName;
		this.artifactOwner = artifactOwner;
		this.productOwner = productOwner;
		this.date = date;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "disc_type_id", insertable = true, updatable = true, nullable = false, unique = false)
	public DiscrepancyType getDiscType() {
		return discType;
	}

	@Column(name = "formatted_id", nullable = false)
	public String getFormattedID() {
		return formattedID;
	}

	@Column(name = "artifact_name", nullable = false)
	public String getArtifactName() {
		return artifactName;
	}

	@Column(name = "artifact_ref", nullable = false)
	public String getArtifactRef() {
		return artifactRef;
	}

	@Column(name = "team_name", nullable = true)
	public String getTeamName() {
		return teamName;
	}

	@Column(name = "artifact_owner", nullable = true)
	public String getArtifactOwner() {
		return artifactOwner;
	}

	@Column(name = "product_owner", nullable = true)
	public String getProductOwner() {
		return productOwner;
	}

	@Column(name = "created_date", nullable = true, updatable = false)
	public Date getDate() {
		return date;
	}
	
	public void setDiscType(DiscrepancyType discType) {
		this.discType = discType;
	}


	public void setFormattedID(String formattedID) {
		this.formattedID = formattedID;
	}


	public void setArtifactName(String artifactName) {
		this.artifactName = artifactName;
	}


	public void setArtifactRef(String artifactRef) {
		this.artifactRef = artifactRef;
	}


	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public void setArtifactOwner(String artifactOwner) {
		this.artifactOwner = artifactOwner;
	}


	public void setProductOwner(String productOwner) {
		this.productOwner = productOwner;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	@Override
	public String toString() {
		return "DiscrepancrReport [id=" + id + ", discType=" + discType + ", formattedID=" + formattedID
				+ ", artifactName=" + artifactName + ", artifactRef=" + artifactRef + ", teamName=" + teamName
				+ ", artifactOwner=" + artifactOwner + ", productOwner=" + productOwner + ", date=" + date + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((artifactName == null) ? 0 : artifactName.hashCode());
		result = prime * result + ((artifactRef == null) ? 0 : artifactRef.hashCode());
		result = prime * result + ((artifactOwner == null) ? 0 : artifactOwner.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((discType == null) ? 0 : discType.hashCode());
		result = prime * result + ((formattedID == null) ? 0 : formattedID.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((productOwner == null) ? 0 : productOwner.hashCode());
		result = prime * result + ((teamName == null) ? 0 : teamName.hashCode());
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
		DiscrepancyReport other = (DiscrepancyReport) obj;
		if (artifactName == null) {
			if (other.artifactName != null)
				return false;
		} else if (!artifactName.equals(other.artifactName))
			return false;
		if (artifactRef == null) {
			if (other.artifactRef != null)
				return false;
		} else if (!artifactRef.equals(other.artifactRef))
			return false;
		if (artifactOwner == null) {
			if (other.artifactOwner != null)
				return false;
		} else if (!artifactOwner.equals(other.artifactOwner))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (discType == null) {
			if (other.discType != null)
				return false;
		} else if (!discType.equals(other.discType))
			return false;
		if (formattedID == null) {
			if (other.formattedID != null)
				return false;
		} else if (!formattedID.equals(other.formattedID))
			return false;
		if (id != other.id)
			return false;
		if (productOwner == null) {
			if (other.productOwner != null)
				return false;
		} else if (!productOwner.equals(other.productOwner))
			return false;
		if (teamName == null) {
			if (other.teamName != null)
				return false;
		} else if (!teamName.equals(other.teamName))
			return false;
		return true;
	}
	
	
	
}
