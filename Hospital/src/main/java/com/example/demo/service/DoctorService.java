package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.Treatment;

public interface DoctorService {

	Iterable<Treatment> findAll();

	List<Treatment> search(String q);

	Optional<Treatment> findById(int id);

	void save(Treatment treatment);

	void delete(int id);
}
