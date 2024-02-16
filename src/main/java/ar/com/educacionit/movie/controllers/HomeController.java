package ar.com.educacionit.movie.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HomeController {
	
	@Autowired

	
	// cuando ingrese a http://localhost:8080 viene acá
	@RequestMapping(value={"/"}, method =RequestMethod.GET)
	public String home() {

		//redirecciona a src/main/resources/static/index.html
		return "redirect:/swagger-ui/index.html"; //asume que la extension es .html
	}
}
