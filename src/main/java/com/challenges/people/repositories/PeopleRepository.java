package com.challenges.people.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.challenges.people.model.People;

@Repository
public interface PeopleRepository extends JpaRepository<People, Long> {

}
