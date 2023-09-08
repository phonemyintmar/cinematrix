package mm.com.cinematrix.db.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "ob_movie")
@Setter
@Getter
public class Movie {

    @Id
    private String movieId;

    private String movieName;

    private String cast;

    private String genre;

    private String bannerUrl;

    private String trailerUrl;

    private String description;

    @Enumerated(EnumType.STRING)
    private MovieType movieType;

    private int moviePriority;

    private LocalDateTime updatedDate;

    @JsonIgnore
    private Double totalIncome;
}
