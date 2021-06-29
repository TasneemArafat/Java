package com.example.LoginReg.Services;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.example.LoginReg.Repositories.EventRepository;
import com.example.LoginReg.Repositories.EventUserRepository;
import com.example.LoginReg.Repositories.MessageRepository;
import com.example.LoginReg.Repositories.StateRepository;
import com.example.LoginReg.Repositories.UserRepository;
import com.example.LoginReg.models.Event;
import com.example.LoginReg.models.Message;
import com.example.LoginReg.models.State;
import com.example.LoginReg.models.User;

@Service
public class appService {

	private final EventRepository eventRepo;
	private final EventUserRepository eventUserRepo;
	private final MessageRepository messageRepo;
	private final StateRepository stateRepo;
	private final UserRepository userRepo;
	public appService(EventRepository eventRepo, EventUserRepository eventUserRepo, MessageRepository messageRepo,
			StateRepository stateRepo, UserRepository userRepo) {
		super();
		this.eventRepo = eventRepo;
		this.eventUserRepo = eventUserRepo;
		this.messageRepo = messageRepo;
		this.stateRepo = stateRepo;
		this.userRepo = userRepo;
	}
	
	public List<State> getAllStates(){
		return stateRepo.findAll();
	}
	
	public void createState(State state) {
		stateRepo.save(state);
	}
	
	public List<Event> eventsNotInState(State state){
		return eventRepo.findByEventstateIsNot(state);
	}
	
	public void createEvent(Event event) {
		eventRepo.save(event);
	}
	
	public void joinEvent(Event event, User user) {
		if(event.getUsers() == null) {
			List<User> users = new ArrayList<User>();
			users.add(user);
			event.setUsers(users);
		}
		else {
			event.getUsers().add(user);
		}
		eventRepo.save(event);
	}
	
	public void cancelEvent(Event event, User user) {
		event.getUsers().remove(user);
		eventRepo.save(event);
	}

	public Event getEventById(Long eventId) {
		return eventRepo.findById(eventId).orElse(null);
	}

	public void createMessage(Message mess) {
		messageRepo.save(mess);
		
	}

	public Event updateEvent(@Valid Event event) {
		eventRepo.save(event);
		return event;
	}

	public void deleteEvent(Long id) {
		eventRepo.deleteById(id);
		
	}
}
