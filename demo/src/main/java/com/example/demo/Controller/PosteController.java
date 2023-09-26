package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dtos.FormDto;
import com.example.demo.dtos.PostesDto;
import com.example.demo.models.Postes;
import com.example.demo.repositories.PostesRepository;
import com.example.demo.service.PostesService;




@RestController
@RequestMapping("/posts")

 public class PosteController {
	
	@Autowired
	private PostesService postService;
	
	
	@GetMapping
	public List<PostesDto> listarTodos(){
		return postService.buscarTodos();
	}
	
	@GetMapping("/buscarPorNome")
	public List<PostesDto> listarPorTitulo(String titulo){
		return postService.buscarPorTitulo(titulo);
	}
	
	@PostMapping
	public ResponseEntity<PostesDto> cadastrar(@RequestBody FormDto dados) {
		 Postes post=postService.cadastrar(dados);
		return new ResponseEntity<PostesDto>( new PostesDto(post) ,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> apagar(@PathVariable Long id) {
		postService.apagar(id);
		return  new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
 
 }
