package com.example.DojosAndNinjas.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.DojosAndNinjas.Repository.DojoRepository;
import com.example.DojosAndNinjas.Repository.NinjaRepository;
import com.example.DojosAndNinjas.models.Dojos;
import com.example.DojosAndNinjas.models.Ninja;

@Service
public class ApiService {
	
	private final DojoRepository DojoRepo;
	private final NinjaRepository NinjaRepo;
	
	public ApiService(DojoRepository dojoRepo, NinjaRepository ninjaRepo) {
		super();
		DojoRepo = dojoRepo;
		NinjaRepo = ninjaRepo;
	}
	
	public List<Dojos> findAllDojos(){
		return DojoRepo.findAll();
	}
	
	public List<Ninja> findAllNinjas(){
		return NinjaRepo.findAll();
	}
	
	public Dojos createDojo(Dojos Dojo) {
		return DojoRepo.save(Dojo);
	}
	
	public Ninja createNinja(Ninja ninja) {
		return NinjaRepo.save(ninja);
	}
	
	public Ninja findNinjaById(Long id) {
		Optional<Ninja> optionalNinjas = NinjaRepo.findById(id);
		if(optionalNinjas.isPresent()) {
			return optionalNinjas.get();
		}
		else {
			return null;
		}
	}
	
	public Dojos findDojoById(Long id) {
		Optional<Dojos> optionalDojos = DojoRepo.findById(id);
		if(optionalDojos.isPresent()) {
			return optionalDojos.get();
		}
		else {
			return null;
		}
	}

}
