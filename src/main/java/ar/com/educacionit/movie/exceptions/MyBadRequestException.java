package ar.com.educacionit.movie.exceptions;

public class MyBadRequestException extends RuntimeException {
	public MyBadRequestException (String msj) {
		super(msj);
	}
	
}
