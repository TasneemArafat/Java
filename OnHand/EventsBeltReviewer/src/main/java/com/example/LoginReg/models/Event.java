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
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="events")
public class Event {

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
	
    @Size(min=2, max=225)
    private String name;
    
    @Size(min=2, max=225)
    private String location;
    
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date event_date;
    
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(
    		name = "users_events",
    		joinColumns = @JoinColumn(name = "event_id"),
    		inverseJoinColumns = @JoinColumn(name = "user_id")
    	)
    private List<User> users;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="host_id")
    private User host;
    
    @OneToMany(mappedBy="event", fetch = FetchType.LAZY)
    private List<Message> messages;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="state_id")
    private State eventstate;

	public Event() {
		super();
	}


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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Date getEvent_date() {
		return event_date;
	}

	public void setEvent_date(Date event_date) {
		this.event_date = event_date;
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

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}


	public User getHost() {
		return host;
	}

	public void setHost(User host) {
		this.host = host;
	}


	public State getEventstate() {
		return eventstate;
	}


	public void setEventstate(State eventstate) {
		this.eventstate = eventstate;
	}
	
}
