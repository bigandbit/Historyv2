package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Patient;
import com.example.demo.repository.PatientRepository;


@Service
public class PatientServiceImpl implements PatientService {
	@Autowired
    private PatientRepository patientRepository;

    @Override
    public Iterable<Patient> findAll() {
        return patientRepository.findAll();
    }

    @Override
    public List<Patient> search(String q) {
        return patientRepository.findByNameContaining(q);
    }

    @Override
    public Optional<Patient> findById(int id) {
        return patientRepository.findById(id);
    }

    @Override
    public void save(Patient contact) {
    	patientRepository.save(contact);
    }

    @Override
    public void delete(int id) {
    	patientRepository.deleteById(id);
    }
}
