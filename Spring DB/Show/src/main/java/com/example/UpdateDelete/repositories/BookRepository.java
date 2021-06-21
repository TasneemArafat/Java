package com.example.UpdateDelete.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.UpdateDelete.models.Book;

@Repository
public interface BookRepository extends CrudRepository<Book,Long>{
	
	List<Book> findAll();
	
	List<Book> findByDescriptionContaining(String search);
	
	long countByTitleContaining(String search);
	
	long deleteByTitleStartingWith(String search);
	
	void deleteById(Integer id);

}
