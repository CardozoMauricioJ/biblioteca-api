package com.example.biblioteca.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Libro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long id;
	private String titulo;
	private String autor;
	private String genero;
	private Date añoPublicacion;
	
	//Getters and Setters
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
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public Date getAñoPublicacion() {
		return añoPublicacion;
	}
	public void setAñoPublicacion(Date añoPublicacion) {
		this.añoPublicacion = añoPublicacion;
	}

}
