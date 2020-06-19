package com.cubic.ipm.model;


import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;

//@Entity(name = "ssn")
public class SocialSecurityNumber {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	// this regular expression is to accept zero or three digits
	@Pattern(regexp = "^$|[0-9]{3}|/ ", message = "First three digits of social security is not valid")
	// this is another way to do
	private String initValue;

	@Pattern(regexp = "^$|[0-9]{2}", message = "Mid two digits of social security is not valid")
	private String midValue;

	@Column(unique = true)
	@Pattern(regexp = "[0-9]{4}", message = "Last four digits of valid social security is required")
	private String lastValue;

	public SocialSecurityNumber() {
	}

	public SocialSecurityNumber(String lastValue) {
		this.lastValue = lastValue;
	}

	public SocialSecurityNumber(String initValue, String midValue, String lastValue) {
		this.initValue = initValue;
		this.midValue = midValue;
		this.lastValue = lastValue;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getInitValue() {
		return initValue;
	}

	public void setInitValue(String initValue) {
		this.initValue = initValue;
	}

	public String getMidValue() {
		return midValue;
	}

	public void setMidValue(String midValue) {
		this.midValue = midValue;
	}

	public String getLastValue() {
		return lastValue;
	}

	public void setLastValue(String lastValue) {
		this.lastValue = lastValue;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((initValue == null) ? 0 : initValue.hashCode());
		result = prime * result + ((lastValue == null) ? 0 : lastValue.hashCode());
		result = prime * result + ((midValue == null) ? 0 : midValue.hashCode());
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
		SocialSecurityNumber other = (SocialSecurityNumber) obj;
		if (initValue == null) {
			if (other.initValue != null)
				return false;
		} else if (!initValue.equals(other.initValue))
			return false;
		if (lastValue == null) {
			if (other.lastValue != null)
				return false;
		} else if (!lastValue.equals(other.lastValue))
			return false;
		if (midValue == null) {
			if (other.midValue != null)
				return false;
		} else if (!midValue.equals(other.midValue))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SocialSecurityNumber [id=" + id + ", initValue=" + initValue + ", midValue=" + midValue + ", lastValue="
				+ lastValue + "]";
	}

}
