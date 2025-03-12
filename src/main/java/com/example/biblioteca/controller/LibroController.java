package com.example.biblioteca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.biblioteca.repository.LibroRepository;
import com.example.biblioteca.entity.Libro;

//Indicamos que es un controlador rest
@RestController
@RequestMapping("/biblioteca")//esta sera la raiz de la url, es decir http://127.0.0.1:8080/biblioteca/
public class LibroController {
	
	//Inyectamos el servicio para poder hacer uso de el
	@Autowired
	private LibroRepository libroRepository;
	
	/*Este método se hará cuando por una petición GET (como indica la anotación) se llame a la url 
    http://127.0.0.1:8080/biblioteca/libros*/
	@GetMapping("/libros")
	public List<Libro> obtenerLibros() {
		//retornará todos los libros
        return libroRepository.findAll();
	}
	
	/*Este método se hará cuando por una petición GET se llame a la url + el id del libro
    http://127.0.0.1:8080/biblioteca/libros/1*/
	@GetMapping("/libros/{id}")
	public ResponseEntity<Libro> obtenerLibroPorId(@PathVariable Long id) {
	    return libroRepository.findById(id)
	            .map(libro -> new ResponseEntity<>(libro, HttpStatus.OK))
	            .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND)); //retorna un libro por id, en caso de no encontrar devuelve el codigo de error 404.
	}
	
	/*Este método se hará cuando por una petición POST se llame a la url
    http://127.0.0.1:8080/biblioteca/libros/*/
	@PostMapping("/libros")
	public Libro crearLibro(@RequestBody Libro libro) {
		
		//Este metodo guardara el libro enviado
		return libroRepository.save(libro);
	}
	
	/*Este método se hará cuando por una petición PUT se llame a la url + el id del libro
    http://127.0.0.1:8080/biblioteca/libros/1*/
	@PutMapping("/libros/{id}")
    public ResponseEntity<Libro> modificarLibro(@PathVariable Long id, @RequestBody Libro libroActualizado) {
        return libroRepository.findById(id)
                .map(libroExistente -> {
                    libroExistente.setTitulo(libroActualizado.getTitulo());
                    libroExistente.setAutor(libroActualizado.getAutor());
                    libroExistente.setGenero(libroActualizado.getGenero());
                    libroExistente.setAñoPublicacion(libroActualizado.getAñoPublicacion());
                    Libro libroGuardado = libroRepository.save(libroExistente);
                    return new ResponseEntity<>(libroGuardado, HttpStatus.OK); //Este metodo actualizara al libro enviado
                })
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND)); //Codigo error 404
    }
	
	/*Este método se hará cuando por una petición DELETE se llame a la url + el id del libro
    http://127.0.0.1:8080/biblioteca/libros/1*/
	@DeleteMapping("/libros/{id}")
	public ResponseEntity<Void> eliminarLibro(@PathVariable Long id) {
		if (libroRepository.existsById(id)) {
			libroRepository.deleteById(id);			
			return new ResponseEntity<>(HttpStatus.NO_CONTENT); //Esto método, recibira el id de un libro por URL y se borrará de la bd.
		    } else{
				return new ResponseEntity<>(HttpStatus.NOT_FOUND); //Codigo de error 404 en caso de no encontrar un libro con el id indicado.
			}
	}
	

}
