package com.cubic.ipm.model;


import javax.persistence.*;

import com.cubic.ipm.enums.Flags;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "technology")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Technology{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotEmpty(message="Technology cannot be empty.")
	@Column(unique = true)
	private String name;

	@Enumerated(EnumType.STRING)
	private Flags flag;

	public Technology() {
	}

	public Technology(String name) {
		this.name = name;
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

	public Flags getFlag() {
		return flag;
	}

	public void setFlag(Flags flag) {
		this.flag = flag;
	}

	@Override
	public String toString() {
		return "Technology [id=" + id + ", name=" + name + "]";
	}

}
