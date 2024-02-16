package ar.com.educacionit.movie.exceptions;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionControllerHandler {
	@ExceptionHandler
	public ResponseEntity<?> fallaEnValidacion(MethodArgumentNotValidException ex){
		 //logica de control del error
		List <String> errors = ex.getBindingResult().getAllErrors()
				.stream()
				.map(x-> x.getObjectName() + " - " + x.getDefaultMessage())
				.collect(Collectors.toList());
		return ResponseEntity.badRequest().body(errors);
//		return ResponseEntity.badRequest().body(ex.getBindingResult().getAllErrors());
	}
}
