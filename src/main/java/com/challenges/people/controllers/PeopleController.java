package com.challenges.people.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.challenges.people.model.People;
import com.challenges.people.repositories.PeopleRepository;

@RestController
@RequestMapping("/rest/people")
public class PeopleController {
	
	@Autowired
	private PeopleRepository repository;

	@GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<People>> findAll() {
		final List<People> people = repository.findAll();
		
		return new ResponseEntity<>(people, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity findById(@PathVariable("id") Long id) {
		Optional<People> optional = repository.findById(id);
		
		ResponseEntity response;
		
		if (optional.isPresent()) {
			response = new ResponseEntity<>(optional.get(), HttpStatus.OK);
		} else {
			response = new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		
		return response;
	}
	
	@PostMapping(value = "/save/{id}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<People> save(@PathVariable("id") Long id, @RequestBody People body) {
		Optional<People> optional = repository.findById(id);
		
		ResponseEntity<People> response;
		
		if (optional.isPresent()) {
			body.setId(id);
			
			response = new ResponseEntity<>(repository.save(body), HttpStatus.OK);
		} else {
			body.setId(id);
			
			response = new ResponseEntity<>(repository.save(body), HttpStatus.CREATED);
		}
		
		return response; 
	}
	
	@DeleteMapping(value = "/remove/{id}")
	public ResponseEntity remove(@PathVariable("id") Long id) {
		Optional<People> optional = repository.findById(id);
		
		ResponseEntity response;
		
		if (optional.isPresent()) {
			repository.delete(optional.get());
			
			response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			response = new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		
		return response;
	}
}
