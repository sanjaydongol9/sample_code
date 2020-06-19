package com.cubic.ipm.model;

import java.util.Date;

import javax.persistence.*;

import com.cubic.ipm.enums.Flags;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
@Table(name = "interview")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Interview {
	@Id
	@GeneratedValue
	private Long id;
	
	@OneToOne
	@JoinColumn(name = "vendor_call_taker")
	private User vendorCallTaker; 
	
	@Column(name = "vendor_name")
	private String vendorName; 
	
	@OneToOne
	@JoinColumn(name = "sales_representive")
	private User salesRepresentive; 
	
	@OneToOne
	@JoinColumn(name = "proxy_id")
	private Proxy proxy; 
	
	@Column(name = "client_name")
	private String clientName; 
	
	private String location;
	
	@OneToOne
	@JoinColumn(name = "candidate")
	private Candidate candidate; 
	
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern = "MM/dd/yyyy hh:mm:ss")
	@Column(name = "interview_date")
	private Date interviewDate;
	
	@Enumerated
	private InterviewStatus status;
	
	@Lob
	private String comment;

	@Enumerated(EnumType.STRING)
	private Flags flag;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getVendorCallTaker() {
		return vendorCallTaker;
	}

	public void setVendorCallTaker(User vendorCallTaker) {
		this.vendorCallTaker = vendorCallTaker;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public User getSalesRepresentive() {
		return salesRepresentive;
	}

	public void setSalesRepresentive(User salesRepresentive) {
		this.salesRepresentive = salesRepresentive;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Candidate getCandidate() {
		return candidate;
	}

	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}

	public Date getInterviewDate() {
		return interviewDate;
	}

	public void setInterviewDate(Date interviewDate) {
		this.interviewDate = interviewDate;
	}

	public InterviewStatus getStatus() {
		return status;
	}

	public void setStatus(InterviewStatus status) {
		this.status = status;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Proxy getProxy() {
		return proxy;
	}

	public void setProxy(Proxy proxy) {
		this.proxy = proxy;
	}

	public Flags getFlag() {
		return flag;
	}

	public void setFlag(Flags flag) {
		this.flag = flag;
	} 
	
	
}
