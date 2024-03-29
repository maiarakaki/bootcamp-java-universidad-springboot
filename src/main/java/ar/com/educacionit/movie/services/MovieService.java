package ar.com.educacionit.movie.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ar.com.educacionit.movie.domain.Movie;
import ar.com.educacionit.movie.repository.MovieRepository;

@Service
public class MovieService {
	private final MovieRepository movieRepository;
	
	public MovieService(MovieRepository movieRepository) {
		this.movieRepository = movieRepository;
	}
	
	public List<Movie> findAll() {
		return this.movieRepository.findAll();
	}
	
	public Movie getById(Long id) {
		return this.movieRepository.findById(id).orElse(null);
	}
	
	public void deleteById(Long id) {
		this.movieRepository.deleteById(id);
	}

	public Optional<Movie> searchByTitle(String originalTitle) {
		
		return this.movieRepository.findByOriginalTitle(originalTitle);
	}

	public void createMovie(Movie newMovie) {
		// TODO Auto-generated method stub
		this.movieRepository.save(newMovie);
		
	}
	
	public void updateMovie(Movie movie) {
		this.movieRepository.save(movie);
	}

}
