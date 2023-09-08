package mm.com.cinematrix.business.movie.dto;

import lombok.Data;
import mm.com.cinematrix.db.model.MovieType;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class MovieRequest {
    @NotBlank
    @NotNull
    private String movieName;

    @NotBlank
    @NotNull
    private String cast;

    @NotBlank
    @NotNull
    private String genre;

    @NotBlank
    @NotNull
    private String bannerUrl;

    @NotBlank
    @NotNull
    private String trailerUrl;

    @NotBlank
    @NotNull
    private String description;

    @Enumerated(EnumType.STRING)
    private MovieType movieType;

    @Min(1)
    private int moviePriority;
}
