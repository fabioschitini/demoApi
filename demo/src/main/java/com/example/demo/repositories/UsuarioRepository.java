package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Usuarios;

public interface UsuarioRepository extends  JpaRepository<Usuarios, Long>{

}
