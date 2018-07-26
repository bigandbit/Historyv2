package com.example.demo.model;

public class TreatmentPatient {
	private int id;
	private int id_patient;
	private String name;
	private String hod;
	private String allergic_medicine;

	public TreatmentPatient() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TreatmentPatient(int id, int id_patient, String name, String hod, String allergic_medicine) {
		super();
		this.id = id;
		this.id_patient = id_patient;
		this.name = name;
		this.hod = hod;
		this.allergic_medicine = allergic_medicine;
	}



	public int getId_patient() {
		return id_patient;
	}



	public void setId_patient(int id_patient) {
		this.id_patient = id_patient;
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

	public String getHod() {
		return hod;
	}

	public void setHod(String hod) {
		this.hod = hod;
	}

	public String getAllergic_medicine() {
		return allergic_medicine;
	}

	public void setAllergic_medicine(String allergic_medicine) {
		this.allergic_medicine = allergic_medicine;
	}

}
