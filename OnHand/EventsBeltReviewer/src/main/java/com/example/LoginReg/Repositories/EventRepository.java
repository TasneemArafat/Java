package com.example.LoginReg.Repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.LoginReg.models.Event;
import com.example.LoginReg.models.State;

@Repository
public interface EventRepository extends CrudRepository<Event,Long>{
	
	List<Event> findAll();
	
	List<Event> findByEventstateIsNot(State state);
	
	Optional<Event> findById(Long id);

}
