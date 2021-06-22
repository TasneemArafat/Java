package com.example.Lookify.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.Lookify.models.lookify;
import com.example.Lookify.repositories.lookifyRepository;



@Service
public class lookifyService {
	
	private final lookifyRepository LookifyRepository;

	public lookifyService(lookifyRepository lookifyRepository) {
		LookifyRepository = lookifyRepository;
	}
	
	public List<lookify> allsongs(){
		return LookifyRepository.findAll();
	}
	
	public lookify addSong(lookify song) {
		return LookifyRepository.save(song);
	}
	
	public lookify findById(Long id) {
		Optional<lookify> optionalSong = LookifyRepository.findById(id);
		if(optionalSong.isPresent()) {
			return optionalSong.get();
		}
		else {
			return null;
		}
	}

	public List<lookify> findByArtist(String artist){
		return LookifyRepository.findByArtistContaining(artist);
	}
	
	public void destroy(Long id) {
		LookifyRepository.deleteById(id);
	}
	
	public List<lookify> sortTop10ByRating(){
		return LookifyRepository.findTop10ByOrderByRatingDesc();
	}
	

}
