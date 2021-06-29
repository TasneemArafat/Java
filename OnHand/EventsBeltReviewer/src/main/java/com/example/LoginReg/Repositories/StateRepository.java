package com.example.LoginReg.Repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.LoginReg.models.Event;
import com.example.LoginReg.models.State;

@Repository
public interface StateRepository extends CrudRepository<State,Long>{

	List<State> findAll();
	
}
