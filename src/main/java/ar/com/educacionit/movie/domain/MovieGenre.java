package ar.com.educacionit.movie.domain;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="genres")
public class MovieGenre {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id; //el nombre del atributo es igual al de la base
		
	@Column(name="name", length=255, nullable=false)
	private String name;
	

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
