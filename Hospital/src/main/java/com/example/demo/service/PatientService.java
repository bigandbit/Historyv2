package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.Patient;

public interface PatientService {
	
	Iterable<Patient> findAll();

	List<Patient> search(String q);

	Optional<Patient> findById(int id);

	void save(Patient contact);

	void delete(int id);
}