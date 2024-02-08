package ar.com.educacionit.movie.domain;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table( name = "roles")
public class Role {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(name="role")
	private String role;
	
	public Role() {}
	public Role(Long id, String role) {
		if (id == null || role == null ) {
			throw new IllegalArgumentException("Algun campo es null");
		}
		this.id = id;
		this.role = role;
	}
	
	public Role (String role) {
		this.role = role;
	}

	public Long getId() {
		return id;
	}

	public String getRole() {
		return role;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", role=" + role + "]";
	}

	public void setId(Long id) {
		// TODO Auto-generated method stub
		
	}

	public Serializable getID() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void setRole(String role) {
		this.role = role;
	}
	
}
