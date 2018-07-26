package com.example.demo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Treatment")
public class Treatment implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "TREATMENT_ID", nullable = false)
	private int id;

	@Column(name = "PATIENT_ID", nullable = false)
	private int id_patient;

	@Column(name = "HOD")
	private String hod;

	@Column(name = "PRESCRIPTION")
	private String prescription;

	@Column(name = "USE_MEDICINE")
	private String use_medicine;

	@Column(name = "USED_MEDICINE")
	private String used_medicine;

	@Column(name = "ALLERGIC_MEDICINE")
	private String allergic_medicine;

	@Column(name = "RESULT_TEST")
	private String result_test;

	public Treatment() {
		super();
	}

	public Treatment(int id, int id_patient, String hod, String prescription, String use_medicine, String used_medicine,
			String allergic_medicine, String result_test) {
		super();
		this.id = id;
		this.id_patient = id_patient;
		this.hod = hod;
		this.prescription = prescription;
		this.use_medicine = use_medicine;
		this.used_medicine = used_medicine;
		this.allergic_medicine = allergic_medicine;
		this.result_test = result_test;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId_patient() {
		return id_patient;
	}

	public void setId_patient(int id_patient) {
		this.id_patient = id_patient;
	}

	public String getHod() {
		return hod;
	}

	public void setHod(String hod) {
		this.hod = hod;
	}

	public String getPrescription() {
		return prescription;
	}

	public void setPrescription(String prescription) {
		this.prescription = prescription;
	}

	public String getUse_medicine() {
		return use_medicine;
	}

	public void setUse_medicine(String use_medicine) {
		this.use_medicine = use_medicine;
	}

	public String getUsed_medicine() {
		return used_medicine;
	}

	public void setUsed_medicine(String used_medicine) {
		this.used_medicine = used_medicine;
	}

	public String getAllergic_medicine() {
		return allergic_medicine;
	}

	public void setAllergic_medicine(String allergic_medicine) {
		this.allergic_medicine = allergic_medicine;
	}

	public String getResult_test() {
		return result_test;
	}

	public void setResult_test(String result_test) {
		this.result_test = result_test;
	}

	@Override
	public String toString() {
		return "Treatment [id=" + id + ", id_patient=" + id_patient + ", hod=" + hod + ", prescription=" + prescription
				+ ", use_medicine=" + use_medicine + ", used_medicine=" + used_medicine + ", allergic_medicine="
				+ allergic_medicine + ", result_test=" + result_test + "]";
	}

}
