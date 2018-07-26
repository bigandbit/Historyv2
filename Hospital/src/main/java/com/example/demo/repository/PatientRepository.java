package com.example.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Patient;


public interface PatientRepository extends CrudRepository<Patient, Integer> {

    List<Patient> findByNameContaining(String q);

}