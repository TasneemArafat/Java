package com.example.LoginReg.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Entity
@Table(name="users")
public class User {
	    @Id
	    @GeneratedValue(strategy=GenerationType.IDENTITY)
	    private Long id;
	    @Size(min=2, max=225)
	    private String first_name;
	    @Size(min=2, max=225)
	    private String last_name;
	    @Email(message="Email must be valid")
	    private String email;
	    @Size(min=2, max=225)
	    private String location;
	    @Size(min=5, message="Password must be greater than 5 characters")
	    private String password;
	    @Transient
	    private String passwordConfirmation;
	    @Column(updatable=false)
	    private Date createdAt;
	    private Date updatedAt;
	    
	    @ManyToMany(fetch=FetchType.LAZY)
	    @JoinTable(
	    		name = "users_events",
	    		joinColumns = @JoinColumn(name = "user_id"),
	    		inverseJoinColumns = @JoinColumn(name = "event_id")
	    	)
	    private List<Event> events;
	    
	    @OneToMany(mappedBy="user", fetch = FetchType.LAZY)
	    private List<Message> messages;
	    
	    @OneToMany(mappedBy="host", fetch = FetchType.LAZY)
	    private List<Event> hosted_events;
	    
	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name="state_id")
	    private State state;
	    
	    public User() {
	    }	    	  
	    
	    

		public User(String first_name, String last_name, String email, String location, String password,
				String passwordConfirmation, List<Event> events, List<Message> messages, List<Event> hosted_events,
				State state) {
			super();
			this.first_name = first_name;
			this.last_name = last_name;
			this.email = email;
			this.location = location;
			this.password = password;
			this.passwordConfirmation = passwordConfirmation;
			this.events = events;
			this.messages = messages;
			this.hosted_events = hosted_events;
			this.state = state;
		}



		// other getters and setters removed for brevity
	    @PrePersist
	    protected void onCreate(){
	        this.createdAt = new Date();
	    }
	    @PreUpdate
	    protected void onUpdate(){
	        this.updatedAt = new Date();
	    }

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getFirst_name() {
			return first_name;
		}

		public void setFirst_name(String first_name) {
			this.first_name = first_name;
		}

		public String getLast_name() {
			return last_name;
		}

		public void setLast_name(String last_name) {
			this.last_name = last_name;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getLocation() {
			return location;
		}

		public void setLocation(String location) {
			this.location = location;
		}
		

		public List<Event> getHosted_events() {
			return hosted_events;
		}


		public void setHosted_events(List<Event> hosted_events) {
			this.hosted_events = hosted_events;
		}


		public State getState() {
			return state;
		}



		public void setState(State state) {
			this.state = state;
		}



		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getPasswordConfirmation() {
			return passwordConfirmation;
		}

		public void setPasswordConfirmation(String passwordConfirmation) {
			this.passwordConfirmation = passwordConfirmation;
		}

		public Date getCreatedAt() {
			return createdAt;
		}

		public void setCreatedAt(Date createdAt) {
			this.createdAt = createdAt;
		}

		public Date getUpdatedAt() {
			return updatedAt;
		}

		public void setUpdatedAt(Date updatedAt) {
			this.updatedAt = updatedAt;
		}

		public List<Event> getEvents() {
			return events;
		}

		public void setEvents(List<Event> events) {
			this.events = events;
		}

		public List<Message> getMessages() {
			return messages;
		}

		public void setMessages(List<Message> messages) {
			this.messages = messages;
		}
	    
}
