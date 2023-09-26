package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Postes;


public interface PostesRepository extends JpaRepository<Postes,Long> {
	
	List<Postes> findByTituloContaining(String titulo);


}
