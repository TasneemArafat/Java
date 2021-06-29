package com.example.LoginReg.Repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.LoginReg.models.EventUser;

public interface EventUserRepository extends CrudRepository<EventUser,Long> {

	List<EventUser> findAll();
}
