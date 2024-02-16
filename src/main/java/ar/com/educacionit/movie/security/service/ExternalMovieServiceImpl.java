package ar.com.educacionit.movie.security.service;

import java.util.Collections;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import ar.com.educacionit.movie.domain.Movie;

@Component
public class ExternalMovieServiceImpl implements ExternalMovieService{
	private RestTemplate restTemplate = new RestTemplate();

	@Override
	public Movie getMovieById(Long id) {
		// request url
		String url = "https://api.themoviedb.org/3/movie/{id}";

		
		HttpHeaders headers = new HttpHeaders();
//		// set `Content-Type` and `Accept` headers
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
//
//		// example of custom header
		headers.set("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI3NTUzMjlkYWRjOGM3ZTc5ZDFiY2EyYTU5ZTFkMGE1NiIsInN1YiI6IjY1OWI3Nzc5MWQxYmY0MDA5NzFiNjQxNyIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.wZ7wI1Nsh_YeMhS4ByL9s-DBkiePRQLpemNknUAKSWs");
//
//		// build the request
		HttpEntity request = new HttpEntity(headers);
//
//		// make an HTTP GET request with headers
		ResponseEntity<Movie> response = restTemplate.exchange(
		        url,
		        HttpMethod.GET,
		        request,
		        Movie.class,
		        id
		);
		
		
		return response.getBody();
	}
	
}
