package com.example.demo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "patient")
public class Patient implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "PATIENT_ID", nullable = false)
	private int id;
	
	@Column(name = "PATIENT_NAME", nullable = false)
	private String name;
	
	@Column(name = "ADDRESS", nullable = false)
	private String address;
	
	@Column(name = "DOB", nullable = false)
	private String dob;
	
	@Column(name = "SEX", nullable = false)
	private String sex;
	
	@Column(name = "PHONE", nullable = false)
	private String phone;

	public Patient() {
		super();
	}

	public Patient(int id, String name, String address, String dob, String sex, String phone) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.dob = dob;
		this.sex = sex;
		this.phone = phone;
	}

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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Patient [id=" + id + ", name=" + name + ", address=" + address + ", dob=" + dob + ", sex=" + sex
				+ ", phone=" + phone + "]";
	}


}