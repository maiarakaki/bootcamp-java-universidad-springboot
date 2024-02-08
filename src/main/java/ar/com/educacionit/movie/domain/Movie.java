package ar.com.educacionit.movie.domain;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
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
@Table(name="movies")
public class Movie {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id; //el nombre del atributo es igual al de la base
	
	   @ManyToMany(fetch=FetchType.EAGER)
		@JoinTable(
				name="genres_x_movies",
				joinColumns = @JoinColumn(name="movie_id"),
				inverseJoinColumns = @JoinColumn(name="genre_id"))
	   private Set<MovieGenre> genres = new HashSet<>();

	
	//@Column(name="nombre de la columna en la BBDD")
	@Column(name="adult", nullable=false)
	private Boolean adult;
	
	@Column(name="original_language", length = 255, nullable=true)
	private String originalLanguage;
	
	@Column(name="original_title", unique=true, nullable=false, length=255)
	private String originalTitle;
	
	@Column(name="overview", nullable=false)
	private String overview;
	
	@Column(name="popularity")
	private Double popularity;
	
	@Column(name="poster_path")
	private String posterPath;
	
	@Column(name="release_date")
	private String releaseDate;
	
	@Column(name="title", nullable=false)
	private String title;
	
	@Column(name="video")
	private Boolean video;
	
	@Column(name="vote_average")
	private Double voteAverage;
	
	@Column(name="vote_count")
	private Integer voteCount;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getAdult() {
		return adult;
	}

	public void setAdult(Boolean adult) {
		this.adult = adult;
	}

	public String getOriginalLanguage() {
		return originalLanguage;
	}

	public void setOriginalLanguage(String originalLanguage) {
		this.originalLanguage = originalLanguage;
	}

	public String getOriginalTitle() {
		return originalTitle;
	}

	public void setOriginalTitle(String originalTitle) {
		this.originalTitle = originalTitle;
	}

	public String getOverview() {
		return overview;
	}

	public void setOverview(String overview) {
		this.overview = overview;
	}

	public Double getPopularity() {
		return popularity;
	}

	public void setPopularity(Double popularity) {
		this.popularity = popularity;
	}

	public String getPosterPath() {
		return posterPath;
	}

	public void setPosterPath(String posterPath) {
		this.posterPath = posterPath;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Boolean getVideo() {
		return video;
	}

	public void setVideo(Boolean video) {
		this.video = video;
	}

	public Double getVoteAverage() {
		return voteAverage;
	}

	public void setVoteAverage(Double voteAverage) {
		this.voteAverage = voteAverage;
	}

	public Integer getVoteCount() {
		return voteCount;
	}

	public void setVoteCount(Integer voteCount) {
		this.voteCount = voteCount;
	}
	
	

	public Set<MovieGenre> getGenres() {
		return genres;
	}

	public void setGenres(Set<MovieGenre> genres) {
		this.genres = genres;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", genres=" + genres + ", adult=" + adult + ", originalLanguage=" + originalLanguage
				+ ", originalTitle=" + originalTitle + ", overview=" + overview + ", popularity=" + popularity
				+ ", posterPath=" + posterPath + ", releaseDate=" + releaseDate + ", title=" + title + ", video="
				+ video + ", voteAverage=" + voteAverage + ", voteCount=" + voteCount + "]";
	}

	
	

	
	
}
