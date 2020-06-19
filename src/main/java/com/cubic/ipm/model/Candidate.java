package com.cubic.ipm.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name = "candidate")
@JsonInclude(Include.NON_NULL)
@DynamicUpdate(value=true)
public class Candidate extends Person {

	@Id
	@GeneratedValue
	private Long id;

	// @Valid
	// @NotNull(message = "SSN required!")
	// @OneToOne(cascade = CascadeType.ALL)
	// @JoinColumn(name = "ssn_id")
	// private SocialSecurityNumber ssn;

	//@NotEmpty(message = "Skype id required!")
	private String skypeId;

	@Column(name = "resume_location")
	private String resumeLocation;

	@Valid
	@NotNull(message = "Technology required!")
	@OneToOne
	@JoinColumn(name = "technology_id")
	private Technology technology;
	
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "vendor_call_taker_id")
    private User vcTaker;
	
	public Candidate() {
	}

	public Candidate(String firstName, String lastName, String email, Address address, Phone phone, String skypeId) {
		super(firstName, lastName, email, address, phone);
		this.skypeId = skypeId;
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

	public String getResumeLocation() {
		return resumeLocation;
	}

	public void setResumeLocation(String resumeLocation) {
		this.resumeLocation = resumeLocation;
	}

	public User getVcTaker() {
		return vcTaker;
	}

	public void setVcTaker(User vcTaker) {
		this.vcTaker = vcTaker;
	}
	@Override
	public String toString() {
		return "Candidate [id=" + id + ", skypeId=" + skypeId + ", technology=" 
	+ technology + "  ]";
	}
	

}
