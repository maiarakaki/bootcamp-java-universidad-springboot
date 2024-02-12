package ar.com.educacionit.movie.domain;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="genres")
public class MovieGenre {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id; //el nombre del atributo es igual al de la base
		
	@Column(name="name", length=255, nullable=false)
	private String name;
	
	public MovieGenre() {}
	
	public MovieGenre(Long id) {
		this.id = id;
//		this.name = value;
	}
	

	@Override
	public String toString() {
		return "MovieGenre [id=" + id + ", name=" + name + ", ]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	
}
