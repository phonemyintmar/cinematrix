package mm.com.cinematrix.business.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import mm.com.cinematrix.db.model.MovieType;
import org.hibernate.validator.constraints.Length;

import javax.annotation.Nullable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

@Data
@AllArgsConstructor
public class MovieRequest {
    @NotBlank
    @NotNull
    private String movieName;

    @NotBlank
    @NotNull
    private String movieCast;

    @NotBlank
    @NotNull
    private String genre;

    @NotBlank
    @NotNull
    @Pattern(regexp = "^(https?://)?([a-zA-Z0-9.-]+\\.[a-z]{2,6})(/\\S*)?$")
    private String bannerUrl;

    @Nullable
    private String featureUrl;

    @NotNull
    private Boolean isFeatured;

    @NotBlank
    @NotNull
    @Pattern(regexp = "^(https?://)?([a-zA-Z0-9.-]+\\.[a-z]{2,6})(/\\S*)?$")
    private String trailerUrl;

    @NotBlank
    @NotNull
    @Length(min = 20)
    private String description;

    @Enumerated(EnumType.STRING)
    private MovieType movieType;

    @NotNull
    private LocalDate startDate;

    @NotNull
    private LocalDate endDate;

    @Min(1)
    private int moviePriority;
}
