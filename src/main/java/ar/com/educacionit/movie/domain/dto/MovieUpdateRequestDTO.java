package ar.com.educacionit.movie.domain.dto;



import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@Getter
//@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MovieUpdateRequestDTO {
	@NotNull
	private Long id;
	@NotBlank
	private String originalTitle;
	@NotBlank
	private String overview;
	@NotNull
	private Double popularity;
	@NotBlank
	private String posterPath;
	@NotNull
	private Double voteAverage;
	@NotNull
	@Min(0)
	@Max(10)
	private Integer voteCount;
	
	
}
