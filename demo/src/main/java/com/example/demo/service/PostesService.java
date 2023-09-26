package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.dtos.FormDto;
import com.example.demo.dtos.PostesDto;
import com.example.demo.models.Postes;
import com.example.demo.models.Usuarios;
import com.example.demo.repositories.PostesRepository;
import com.example.demo.repositories.UsuarioRepository;

@Service
public class PostesService {

	@Autowired
	private PostesRepository postRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public List<PostesDto> converterLista(List<Postes> lista){
		return lista.stream().map(PostesDto::new).collect(Collectors.toList());
	}
	
	public  List<PostesDto> buscarTodos(){
		return  this.converterLista(this.postRepository.findAll());
	}
	
	public List<PostesDto> buscarPorTitulo(String titulo) {
		return this.converterLista(this.postRepository.findByTituloContaining(titulo));
	}
	
	public Postes cadastrar(FormDto dados) {
		Postes post= new Postes(dados);
		
		Optional<Usuarios> op=usuarioRepository.findById(dados.usuario());
		if(op.isPresent()) {
			post.setUsuario(op.get());
		}
		postRepository.save(post);
		return post;
	}


	public void apagar(Long id) {
		// TODO Auto-generated method stub
		this.postRepository.deleteById(id);
	}
	
}

