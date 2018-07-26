package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.History;
import com.example.demo.repository.HistoryRepository;

@Service
public class HistoryServiceImpl implements HistoryService{
	
	@Autowired private HistoryRepository historyRepository;
	
	@Override
	public Iterable<History> findAll() {
		return historyRepository.findAll();
	}

	@Override
	public List<History> search(String q) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<History> findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(History history) {
		historyRepository.save(history);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

}
