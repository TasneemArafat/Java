package com.example.DriversLicense.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.DriversLicense.Repository.LicenseRepository;
import com.example.DriversLicense.Repository.PersonRepository;
import com.example.DriversLicense.models.License;
import com.example.DriversLicense.models.Person;

@Service
public class ApiService {
	
	private final PersonRepository personRepo;
	private final LicenseRepository licenseRepo;
	
	public ApiService(PersonRepository personRepo, LicenseRepository licenseRepo) {
		super();
		this.personRepo = personRepo;
		this.licenseRepo = licenseRepo;
	}
	
	
	
	public Person createPerson(Person person) {
		return personRepo.save(person);
		
	}
	
	public License createLicense(License l){
        License topNumber = licenseRepo.findTopByOrderByNumberDesc();
        int number;
        if (topNumber == null)
            number = 1;
        else {
            number = Integer.parseInt(topNumber.getNumber());
            number++;
        }
        String numberString = String.format("%07d",number);
        l.setNumber(numberString);
        return licenseRepo.save(l);
    }
	
	public List<Person> findAllPersons(){
		return personRepo.findAll();
	}
	
	public List<License> findAllLicenses(){
		return licenseRepo.findAll();
	}
	
	public List<Person> findAllNullLicenses(){
		return personRepo.findByLicenseNumberIsNull();
	}

	public Person findById(Long id) {
		Optional<Person> optionalPerson = personRepo.findById(id);
		if(optionalPerson.isPresent()) {
			return optionalPerson.get();
		}
		else {
			return null;
		}
	}
}
