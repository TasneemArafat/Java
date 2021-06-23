package com.example.StudentRoster.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.StudentRoster.models.Contact;

@Repository
public interface ContactRepository extends CrudRepository<Contact, Long>{
	
	List<Contact> findAll();

}
