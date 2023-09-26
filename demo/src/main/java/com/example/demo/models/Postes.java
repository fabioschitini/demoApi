package com.example.demo.models;

import com.example.demo.dtos.FormDto;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Builder(toBuilder = true)
@Getter
@Setter
@Entity(name="posts")
@AllArgsConstructor
@NoArgsConstructor
public class Postes {
	
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	 private String titulo;
	 private String texto;
	 @ManyToOne
	 private Usuarios usuario;
	 @Enumerated(EnumType.STRING)
	 private Categoria categoria = Categoria.POLITICA;
	 
	 
	public Postes() {}
	
	public Postes(FormDto dados) {
		this.texto=dados.texto();
		this.titulo=dados.titulo();
		this.categoria=dados.categoria();
		}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public Usuarios getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuarios usuario) {
		this.usuario = usuario;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}


}
