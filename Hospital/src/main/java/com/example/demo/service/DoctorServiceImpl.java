package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Treatment;
import com.example.demo.repository.DoctorRepository;

@Service
public class DoctorServiceImpl implements DoctorService {

	@Autowired
	DoctorRepository doctorRepository;

	@Override
	public Iterable<Treatment> findAll() {
		return doctorRepository.findAll();
	}

	@Override
	public Optional<Treatment> findById(int id) {
		return doctorRepository.findById(id);
	}

	@Override
	public void save(Treatment treatment) {
		doctorRepository.save(treatment);
	}

	@Override
	public void delete(int id) {
		doctorRepository.deleteById(id);
	}

	@Override
	public List<Treatment> search(String q) {
		return null;
	}

}
