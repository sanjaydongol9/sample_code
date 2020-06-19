package com.cubic.ipm.model;

import java.util.Date;

import javax.persistence.*;
import javax.validation.Valid;

import com.cubic.ipm.enums.Flags;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import org.springframework.format.annotation.DateTimeFormat;

@MappedSuperclass
@JsonInclude(Include.NON_NULL)
public abstract class Person {

    @NotEmpty(message = "First name required")
    @Column(name = "first_name")

    private String firstName;
    @Column(name = "middle_name")
    private String middleName;

    @NotEmpty(message = "Last name required")
    @Column(name = "last_name")
    private String lastName;

    @Column(unique = true)
    @Email(message = "Invalid Email")
    @NotEmpty(message = "Email required")
    private String email;

    @NotEmpty(message = "Gender is required")
    @Column(name = "gender")
    private String gender;

    @Valid
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;

    @Valid
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "phone_id")
    private Phone phone;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "MM/dd/yyyy hh:mm:ss")
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "MM/dd/yyyy hh:mm:ss")
    private Date updatedDate;


    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "MM/dd/yyyy")
    private Date dob;

    @Enumerated(EnumType.STRING)
    private Flags flag;

    public Person() {
    }

    public Person(String email) {
        this.email = email;
    }

    public Person(String firstName, String lastName, String email, Address address, Phone phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.phone = phone;

    }

    public Flags getFlag() {
        return flag;
    }

    public void setFlag(Flags flag) {
        this.flag = flag;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getDob() { return dob; }

    public void setDob(Date dob) { this.dob = dob; }

    @Override
    public String toString() {
        return "Person [firstName=" + firstName + ", middleName=" + middleName + ", lastName=" + lastName + ", email="
                + email + ", phone=" + phone + ",gender=" + gender +"]";
    }
    
    public String getFullName() {
		String middle = getMiddleName()==null?" ":(" "+getMiddleName());
		return getFirstName() + middle+ " " + getLastName(); 
	}

}
/*,dob=" + dob + "*/