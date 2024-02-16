package ar.com.educacionit.movie.security.controllers;

import java.util.ArrayList;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.com.educacionit.movie.security.dto.AuthenticationRequest;
import ar.com.educacionit.movie.security.services.JpaUserDetailsService;
import ar.com.educacionit.movie.security.utils.JwtUtils;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
	private final AuthenticationManager authManager;
	private final JpaUserDetailsService jpaDetailsService; //tiene un repo interno para acceder a la tabla de usuarios
	private final JwtUtils jwtUtils;
	
	@PostMapping
	public ResponseEntity<String> authenticate (
			@Validated @RequestBody AuthenticationRequest request){
		try {
			
			authManager.authenticate(
					new UsernamePasswordAuthenticationToken(
							request.getUsername(), 
							request.getPassword(),
							new ArrayList<>()));
			SecurityContextHolder.getContext().getAuthentication();
			final UserDetails user = jpaDetailsService.loadUserByUsername(request.getUsername());
			if(user != null) {
				return ResponseEntity.ok(jwtUtils.generateToken(user)); 
			}
			return ResponseEntity.status(400).body("Error de autenticacion");
		} catch(Exception e) {
			return ResponseEntity.status(400).body(e.getMessage());
		}
		
		//returns JWT
		
	}
}
