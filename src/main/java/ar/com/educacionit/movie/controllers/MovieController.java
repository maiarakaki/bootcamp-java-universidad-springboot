package ar.com.educacionit.movie.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.com.educacionit.movie.domain.Movie;
import ar.com.educacionit.movie.repository.MovieRepository;
import ar.com.educacionit.movie.services.MovieService;

@RestController
@RequestMapping("/movies")
public class MovieController {
	
	//@Autowired
	private final MovieService movieService;
	
	public MovieController (MovieService movieService) {
		this.movieService = movieService;
	}
	
	@GetMapping
	public List<Movie> findAllMovies() {
		List<Movie> movies =movieService.findAll();
		return movies;
	}
	
	//una pelicula dada su id
	
	@GetMapping("/{id}")
	public ResponseEntity<Movie> getById(
			@PathVariable("id") Long id
			){
		
		Movie movie =movieService.getById(id);
		
		if (movie == null ) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(movieService.getById(id)) ;
	}
	//crear una pelicula
	
	//eliminar una pelicula
	
	//actualizar una pelicula
	
}
