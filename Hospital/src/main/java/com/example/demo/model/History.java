package com.example.demo.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "history")
public class History {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "HISTORY_ID", nullable = false)
	private int id;

	@Column(name = "USER_ID", nullable = false)
	private int user_id;

	@Column(name = "TREATMENT_ID", nullable = false)
	private int treatment_id;

	@Column(name = "UPDATE_TIME", nullable = false)
	private Timestamp time;

	public History() {
		super();
	}
	
	public History(int user_id, int treatment_id, Timestamp time) {
		super();
		this.user_id = user_id;
		this.treatment_id = treatment_id;
		this.time = time;
	}

	public History(int id, int user_id, int treatment_id, Timestamp time) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.treatment_id = treatment_id;
		this.time = time;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getTreatment_id() {
		return treatment_id;
	}

	public void setTreatment_id(int treatment_id) {
		this.treatment_id = treatment_id;
	}

	public Timestamp getTime() {
		return time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

}
