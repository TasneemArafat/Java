package com.example.DojosAndNinjas.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.DojosAndNinjas.models.Dojos;

@Repository
public interface DojoRepository extends CrudRepository<Dojos,Long>{

	List<Dojos> findAll();

}
