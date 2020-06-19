package com.cubic.ipm.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "users")
@JsonInclude(Include.NON_NULL)
public class User extends Person {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(unique = true)
	private String username;

	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String password;

	@Transient
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String rePassword;

	private Boolean enable;

	@Enumerated(EnumType.STRING)
	private Role role;

//	@ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
//	@JoinTable(name = "user_control", joinColumns = @JoinColumn(name = "supervisor_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
//
//	private Set<User> supervisors = new HashSet<User>();
//
//	@ManyToMany(mappedBy = "supervisors", fetch = FetchType.EAGER)
//	private Set<User> users = new HashSet<User>();

	// private List<User> supervisors;
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "marketer")
	private List<UserControl> controllableUsers; 
	
	

	public List<UserControl> getControllableUsers() {
		return controllableUsers;
	}

	public void setControllableUsers(List<UserControl> controllableUsers) {
		this.controllableUsers = controllableUsers;
	}

	public User() {
	}

	public User(String email, String password, String rePassword, Role role) {
		super(email);
		this.password = password;
		this.rePassword = rePassword;
		this.role = role;
	}

	public User(String firstName, String lastName, String email, Address address, Phone phone, String password,
			String rePassword, Role role) {
		super(firstName, lastName, email, address, phone);
		this.password = password;
		this.rePassword = rePassword;
		this.role = role;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRePassword() {
		return rePassword;
	}

	public void setRePassword(String rePassword) {
		this.rePassword = rePassword;
	}

	public Boolean getEnable() {
		return enable;
	}

	public void setEnable(Boolean enable) {
		this.enable = enable;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	// public List<User> getSupervisors() {
	// return supervisors;
	// }
	//
	// public void setSupervisors(List<User> supervisors) {
	// this.supervisors = supervisors;
	// }

//	public Set<User> getSupervisors() {
//		return supervisors;
//	}
//
//	public void setSupervisors(Set<User> supervisors) {
//		this.supervisors = supervisors;
//	}
//
//	public Set<User> getUsers() {
//		return users;
//	}
//
//	public void setUsers(Set<User> users) {
//		this.users = users;
//	}
	
	@JsonCreator
	public User(String mapKey) {
		String[] key = mapKey.split("=");
		this.setId(Long.valueOf(key[0]));
	}

	@Override
	//@JsonValue
	public String toString() {
		return id + "=" + getFirstName() + " " + getLastName();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
//		result = prime * result + ((getFirstName() == null) ? 0 : getFirstName().hashCode());
//		result = prime * result + ((getLastName() == null) ? 0 : getLastName().hashCode());
		
//		result = prime * result + ((role == null) ? 0 : role.hashCode());
//		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (obj instanceof User) {
			User user = (User) obj;
//			return (user.getId().equals(this.getId()) && user.getUsername().equals(this.getUsername())
//					&& user.getRole().toString().equals(this.getRole().toString()));
			
//			return (user.getId().equals(this.getId()) && user.getFirstName().equals(this.getFirstName())
//					&& user.getLastName().toString().equals(this.getLastName().toString()));
			
			return (user.getId().equals(this.getId()));
		}
		return false;
	}
	
	

}
