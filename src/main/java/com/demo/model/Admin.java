package com.demo.model;



import java.util.Date;
import java.util.List;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter

@Entity
//@SQLDelete(sql = "UPDATE admin SET deleted = true WHERE id=?")
//@Where(clause = "deleted=false")
@Valid

public class Admin {
     
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	
	@NotNull
	@Size(min=2, max=30)
	private String name;
	
	@javax.validation.constraints.NotNull
	private String surname;
	
	@NotNull
	private String address;
	
	@NotEmpty
	private String gender;
	@NotNull
	@Min(18)
	private int age;
	
	@NotNull
	@Email(message = "Please enter a valid e-mail address")
    private String email;

	@NotNull
	private String pincode;
	
	@NotNull
	private Date  DOB;
	
	@NotNull
	private Date DOJ;
	
	@NotNull
private boolean deleted = Boolean.FALSE;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public Date getDOB() {
		return DOB;
	}

	public void setDOB(Date dOB) {
		DOB = dOB;
	}

	public Date getDOJ() {
		return DOJ;
	}

	public void setDOJ(Date dOJ) {
		DOJ = dOJ;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public static Object builder() {
		// TODO Auto-generated method stub
		return null;
	}

	
	}
//	@Override
	/*public String toString() {
		return "Admin [id=" + id + ", name=" + name + ", address=" + address + ", gender=" + gender + ", age=" + age
				+ ", email=" + email + "]";
	}

*/	
	

