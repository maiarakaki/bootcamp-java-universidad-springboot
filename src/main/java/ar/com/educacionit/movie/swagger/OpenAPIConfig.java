package ar.com.educacionit.movie.swagger;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class OpenAPIConfig {
	//leer las variables
	@Value("${openapi.dev-url")
	private String devUrl;
	@Value("${openapi.prod-url")
	private String prodUrl;
	
	@Bean
	public OpenAPI myOpenApi(){
		Server devServer = new Server();
		devServer.setUrl(devUrl);
		devServer.setDescription("Server URL in Development environment");
		
		Server prodServer = new Server();
		prodServer.setUrl(prodUrl);
		prodServer.setDescription("Server URL in Production environment");
		
		Contact contact = new Contact();
		contact.setEmail("contact@sarasa.com");
		contact.setName("Sarasa");
		contact.setUrl("http://sarasa.com");
		
		License mitLicense = new License().name("MIT License").url("http://choosealicense.com/license/mit");
		
		Info info = new Info()
				.title("Movie Service API")
				.version("1.0")
				.contact(contact)
				.description("This API exposes endpoints to manage movies.")
				.termsOfService("https://sarasa.com")
				.license(mitLicense);
		return new OpenAPI().info(info).servers(List.of(devServer,prodServer));
		
		
	}
	}