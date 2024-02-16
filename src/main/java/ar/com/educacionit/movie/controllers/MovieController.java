package ar.com.educacionit.movie.controllers;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.com.educacionit.movie.domain.Movie;
import ar.com.educacionit.movie.domain.MovieGenre;
import ar.com.educacionit.movie.domain.dto.MovieRequestDTO;
import ar.com.educacionit.movie.domain.dto.MovieUpdateRequestDTO;
import ar.com.educacionit.movie.exceptions.MovieDoesNotExistException;
import ar.com.educacionit.movie.exceptions.MyBadRequestException;
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
	@PostMapping
	public ResponseEntity<Long> createMovie(
			@RequestBody MovieRequestDTO request
	){
		Optional<Movie> movie = this.movieService.searchByTitle(request.getOriginalTitle());
		if (movie.isPresent()) {
			return ResponseEntity.status(HttpStatus.CREATED).body(movie.get().getId());
		}
		
		//lo crea y luego lo devuelve
		Movie newMovie = new Movie();
		newMovie.setAdult(request.getAdult());
		List <MovieGenre> genres = request.getGenreIds()
				.stream()
				.map(x -> new MovieGenre(x))
				.collect(Collectors.toList());
		newMovie.setGenres(genres);
		newMovie.setOriginalLanguage(request.getOriginalLanguage());
		newMovie.setOriginalTitle(request.getOriginalTitle());
		newMovie.setOverview(request.getOverview());
		newMovie.setPopularity(request.getPopularity());
		newMovie.setPosterPath(request.getPosterPath());
		newMovie.setReleaseDate(request.getReleaseDate());
		newMovie.setTitle(request.getTitle());
		newMovie.setVideo(request.getVideo());
		newMovie.setVoteAverage(request.getVoteAverage());
		newMovie.setVoteCount(request.getVoteCount());
		
		this.movieService.createMovie(newMovie);
		return ResponseEntity.status(HttpStatus.CREATED).body(newMovie.getId());
	}
	
	//eliminar una pelicula
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(
			@PathVariable("id") Long id
			){
		try{
			movieService.deleteById(id);
			return ResponseEntity.ok().build() ;
		} catch(Exception e) {
			return ResponseEntity.internalServerError().build();
		}
	}
	//actualizar una pelicula
	@PutMapping("/{id}")
	public ResponseEntity<Void> updateMovie(
			@PathVariable(name="id", required=true) Long id,
			@RequestBody MovieUpdateRequestDTO request
			){
		if(id != request.getId().longValue()) {

			throw new MyBadRequestException(
					"los id son diferentes");
		} 
		
		
		Movie movie = movieService.getById(id);
//		if(movie == null) {
//			return ResponseEntity.notFound().build();			
//		} else {
		try {
			
			movie.setOriginalTitle(request.getOriginalTitle());
			movie.setOverview(request.getOverview());
			movie.setPopularity(request.getPopularity());
			movie.setPosterPath(request.getPosterPath());
			movie.setVoteAverage(request.getVoteAverage());
			movie.setVoteCount(request.getVoteCount());
			
			movieService.updateMovie(movie);
			return ResponseEntity.ok().build() ;
		} catch (NullPointerException ex){
			throw new MovieDoesNotExistException("La película con id "+ id + " no existe");	
		}
			
//		}
	}
	
}
