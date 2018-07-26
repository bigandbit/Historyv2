package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.AppUser;

public interface UserService {
	Iterable<AppUser> findAll();

	List<AppUser> search(String q);

	Optional<AppUser> findById(int id);

	void save(AppUser appUser);

	void delete(int id);
}
