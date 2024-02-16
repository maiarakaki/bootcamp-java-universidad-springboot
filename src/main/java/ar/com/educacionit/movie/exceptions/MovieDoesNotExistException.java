package ar.com.educacionit.movie.exceptions;

public class MovieDoesNotExistException extends NullPointerException {
	public MovieDoesNotExistException (String msj) {
		super(msj);
	}
	
}
