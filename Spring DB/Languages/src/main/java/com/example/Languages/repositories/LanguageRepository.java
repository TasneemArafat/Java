package com.example.Languages.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.example.Languages.models.Language;


@Repository
public interface LanguageRepository extends CrudRepository<Language,Long> {
	List<Language> findAll();
	void deleteById(Long id);

}
