package com.example.DriversLicense.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.DriversLicense.models.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person,Long> {
	
	List<Person> findAll();
	
	List<Person> findByLicenseNumberIsNull();
}
