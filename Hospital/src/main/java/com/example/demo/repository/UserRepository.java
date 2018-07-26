package com.example.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.AppUser;

public interface UserRepository extends CrudRepository<AppUser, Long>{
	List<AppUser> findByUserNameContaining(String q);
}
