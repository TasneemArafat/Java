package com.example.Languages.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.example.Languages.models.Language;
import com.example.Languages.repositories.LanguageRepository;


@Service
public class LanguageService {

	private final LanguageRepository languageRepository;

	public LanguageService(LanguageRepository languageRepository) {
		this.languageRepository = languageRepository;
	}
	
	public List<Language> allLanguages(){
		return languageRepository.findAll();
	}
	
	public Language createLanguage(Language L) {
		return languageRepository.save(L);
	}
	
	public Language findLanguage(Long id) {
		Optional<Language> optionalLanguage = languageRepository.findById(id);
		if(optionalLanguage.isPresent()) {
			return optionalLanguage.get();
		}
		else {
			return null;
		}
		
	}
	
	public Language updateLanguage(Long id, String name, String creator, Double version) {
		Language lang = findLanguage(id);
		lang.setName(name);
		lang.setCreator(creator);
		lang.setVersion(version);
		languageRepository.save(lang);
		return lang;
	}
	
	public void deleteLanguage(Long id) {
		languageRepository.deleteById(id);
	}

	
	
	
	
}
