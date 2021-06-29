package com.example.LoginReg.Repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.LoginReg.models.Message;

@Repository
public interface MessageRepository extends CrudRepository<Message,Long> {

	List<Message> findAll();
}
