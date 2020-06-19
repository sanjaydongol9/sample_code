/**
 * Copyright 2016 (C) Cubic Technologies LLC
 * All Rights Reserved
 * @author Sanjay Dongol
 */
package com.cubic.ipm.dto;

import java.util.HashMap;
import java.util.List;

import com.cubic.ipm.model.Candidate;
import com.cubic.ipm.model.User;

public class PrivilegeControlDto {
	
	/* List of all Vendor Call Taker & Candidates */
	private HashMap<User, List<Candidate>> vendorCallTakers;
	
	/* List of all Marketer & Vendor Call Taker */
	HashMap<User, List<User>> marketers;
	
	/* Tree View */
	private String label; 
	

	public HashMap<User, List<Candidate>> getVendorCallTakers() {
		return vendorCallTakers;
	}

	public void setVendorCallTakers(HashMap<User, List<Candidate>> vendorCallTakers) {
		this.vendorCallTakers = vendorCallTakers;
	}

	public HashMap<User, List<User>> getMarketers() {
		return marketers;
	}

	public void setMarketers(HashMap<User, List<User>> marketers) {
		this.marketers = marketers;
	}
	
}
