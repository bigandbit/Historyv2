package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.AppUser;
import com.example.demo.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired UserRepository userRepository;
	
	@Override
	public Iterable<AppUser> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AppUser> search(String q) {
		return userRepository.findByUserNameContaining(q);
	}

	@Override
	public Optional<AppUser> findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(AppUser appUser) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}
	
}
