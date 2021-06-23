package com.example.DriversLicense.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.DriversLicense.models.License;

@Repository
public interface LicenseRepository extends CrudRepository<License,String>{
	
	List<License> findAll();
	
	License findTopByOrderByNumberDesc();
	

}
