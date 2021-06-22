package com.example.Lookify.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.Lookify.models.lookify;

@Repository
public interface lookifyRepository extends CrudRepository<lookify,Long>{
	List<lookify> findAll();
	void deleteById(Long id);
	List<lookify> findByArtistContaining(String search);
	List<lookify> findTop10ByOrderByRatingDesc();
}
