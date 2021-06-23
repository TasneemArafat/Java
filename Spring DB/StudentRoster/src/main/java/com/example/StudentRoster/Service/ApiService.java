package com.example.StudentRoster.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.StudentRoster.Repository.ContactRepository;
import com.example.StudentRoster.Repository.StudentRepository;
import com.example.StudentRoster.models.Contact;
import com.example.StudentRoster.models.Students;

@Service
public class ApiService {
	
	private final ContactRepository contactRepo;
	private final StudentRepository studentRepo;
	
	public ApiService(ContactRepository contactRepo, StudentRepository studentRepo) {
		this.contactRepo = contactRepo;
		this.studentRepo = studentRepo;
	}
	
	
	public Students createStudent(Students student) {
		return studentRepo.save(student);
	}
	
	public Contact createContact(Contact contact) {
		return contactRepo.save(contact);
	}
	
	public List<Students> findAllStudents(){
		return studentRepo.findAll();
	}
	
	public List<Contact> findAllContacts(){
		return contactRepo.findAll();
	}
	
	public List<Students> findNoAddressStudents(){
		return studentRepo.findByContactIdIsNull();
	}
}
