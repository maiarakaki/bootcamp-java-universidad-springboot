package ar.com.educacionit.movie.security.service;

import ar.com.educacionit.movie.domain.Movie;

public interface ExternalMovieService {
	public Movie getMovieById(Long id);
}
