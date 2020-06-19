package com.cubic.ipm.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name = "user_control")
@JsonInclude(Include.NON_NULL)
public class UserControl {
	@Id
	@GeneratedValue
	private Integer id;
	
	@OneToOne
	@JoinColumn(name = "vendor_call_taker_id")
	private User vendorCallTaker;
	
	@ManyToOne(fetch = FetchType.EAGER) 
	@JoinColumn(name = "marketer_id", nullable = false)
	private User marketer;
	
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getMarketer() {
		return marketer;
	}

	public void setMarketer(User user) {
		this.marketer = user;
	}

	public User getVendorCallTaker() {
		return vendorCallTaker;
	}

	public void setVendorCallTaker(User vendorCallTaker) {
		this.vendorCallTaker = vendorCallTaker;
	}
	
	
	
}
