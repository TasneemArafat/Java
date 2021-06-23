package com.example.StudentRoster.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name="contacts")
public class Contact {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(min=3)
	@Column(name="address")
	private String address;
	
	@NotNull
	@Size(min=3)
	@Column(name="city")
	private String city;
	
	@NotNull
	@Size(min=3)
	@Column(name="state")
	private String state;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="student_id")
	private Students student;

	public Contact() {
		super();
	}

	public Contact(String address, String city, String state, Students student) {
		super();
		this.address = address;
		this.city = city;
		this.state = state;
		this.student = student;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Students getStudent() {
		return student;
	}

	public void setStudent(Students student) {
		this.student = student;
	}
	
	

}
