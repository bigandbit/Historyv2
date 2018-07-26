package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Treatment;

public interface DoctorRepository extends CrudRepository<Treatment, Integer> {

}
