package ar.com.educacionit.movie.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.com.educacionit.movie.domain.Movie;
import ar.com.educacionit.movie.repository.MovieRepository;

@RestController
@RequestMapping("/movies")
public class MovieController {
	
	@Autowired
	private MovieRepository repository;
	
	@GetMapping
	public List<Movie> findAllMovies() {
		List<Movie> movies =repository.findAll();
		return movies;
	}
}
