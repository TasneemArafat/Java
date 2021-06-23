package com.example.StudentRoster.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.StudentRoster.models.Students;

@Repository
public interface StudentRepository extends CrudRepository<Students, Long>{
	
	List<Students> findAll();
	
	List<Students> findByContactIdIsNull();
}
