package com.example.demo.dtos;

import java.util.List;
import java.util.stream.Collectors;

import com.example.demo.models.Categoria;
import com.example.demo.models.Postes;



public record PostesDto(Long id, String titulo, String texto,String usuario, Categoria categoria) {
	
	public PostesDto(Postes post) {
		this(post.getId(),post.getTitulo(),post.getTexto(), post.getUsuario().getNome(),post.getCategoria());
	}
	

}
