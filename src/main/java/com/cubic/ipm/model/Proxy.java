package com.cubic.ipm.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table (name = "proxy")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Proxy extends Person{
	@Id
	@GeneratedValue
	private Long id; 
	
	@NotEmpty(message = "Skype id required!")
	private String skypeId;
	
	@Valid
	@NotNull(message = "Technology required!")
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "technology_id")
	private Technology technology;
	
	public Proxy() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSkypeId() {
		return skypeId;
	}

	public void setSkypeId(String skypeId) {
		this.skypeId = skypeId;
	}

	public Technology getTechnology() {
		return technology;
	}

	public void setTechnology(Technology technology) {
		this.technology = technology;
	}

	@Override
	public String toString() {
		return "Proxy [id=" + id + ", skypeId=" + skypeId + ", technology=" + technology + ", getId()=" + getId()
				+ ", getSkypeId()=" + getSkypeId() + ", getTechnology()=" + getTechnology() + ", getFirstName()="
				+ getFirstName() + ", getMiddleName()=" + getMiddleName() + ", getLastName()=" + getLastName()
				+ ", getEmail()=" + getEmail() + ", getAddress()=" + getAddress() + ", getPhone()=" + getPhone()
				+ ", getCreatedDate()=" + getCreatedDate() + ", getUpdatedDate()=" + getUpdatedDate() + ", toString()="
				+ super.toString() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}
	
	
}
