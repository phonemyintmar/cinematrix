package mm.com.cinematrix.db.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "cn_movie")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Movie {

    @Id
    private String movieId;

    private String movieName;

    private String movieCast;

    private String genre;

    private String bannerUrl;

    private String trailerUrl;

    private String description;

    @Enumerated(EnumType.STRING)
    private MovieType movieType;

    private int moviePriority;

    private Boolean isFeatured;

    private LocalDate startDate;

    private LocalDate endDate;

    @UpdateTimestamp
    private LocalDateTime updatedDate;

    @CreationTimestamp
    private LocalDateTime createdDate;

    @JsonIgnore
    private Double totalIncome;

    public Movie(String movieId, String movieName, String movieCast, String genre, String bannerUrl, String trailerUrl, String description, MovieType movieType, int moviePriority, Boolean isFeatured, LocalDate startDate, LocalDate endDate) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.movieCast = movieCast;
        this.genre = genre;
        this.bannerUrl = bannerUrl;
        this.trailerUrl = trailerUrl;
        this.description = description;
        this.movieType = movieType;
        this.moviePriority = moviePriority;
        this.isFeatured = isFeatured;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
