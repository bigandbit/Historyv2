package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.History;

public interface HistoryService {
	Iterable<History> findAll();

	List<History> search(String q);

	Optional<History> findById(int id);

	void save(History history);

	void delete(int id);
}
