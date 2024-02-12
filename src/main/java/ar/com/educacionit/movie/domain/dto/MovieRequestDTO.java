package ar.com.educacionit.movie.domain.dto;


import java.util.List;


public class MovieRequestDTO {
	private Long id;
	private Boolean adult;
	private String originalLanguage;
	private String originalTitle;
	private String overview;
	private Double popularity;
	private String posterPath;
	private String releaseDate;
	private String title;
	private Boolean video;
	private Double voteAverage;
	private Integer voteCount;
	private List<Long> genreIds;

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
	
	

	public List<Long> getGenreIds() {
		return genreIds;
	}

	public void setGenreIds(List<Long> genreIds) {
		this.genreIds = genreIds;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", genres=" + genreIds + ", adult=" + adult + ", originalLanguage=" + originalLanguage
				+ ", originalTitle=" + originalTitle + ", overview=" + overview + ", popularity=" + popularity
				+ ", posterPath=" + posterPath + ", releaseDate=" + releaseDate + ", title=" + title + ", video="
				+ video + ", voteAverage=" + voteAverage + ", voteCount=" + voteCount + "]";
	}

	
	

	
	
}
