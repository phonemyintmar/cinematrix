package mm.com.cinematrix.business;

import lombok.extern.slf4j.Slf4j;
import mm.com.cinematrix.business.dto.MovieRequest;
import mm.com.cinematrix.db.model.Movie;
import mm.com.cinematrix.db.repo.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;


@Slf4j
public abstract class BaseBusiness {
    @Autowired
    MovieRepo movieRepo;

    public Object changeMovieRequest(Object object) {
        if (object instanceof MovieRequest) {
            MovieRequest movieRequest = (MovieRequest) object;
            return new Movie(
                    UUID.randomUUID().toString(), movieRequest.getMovieName(), movieRequest.getMovieCast(),
                    movieRequest.getGenre(), movieRequest.getBannerUrl(), movieRequest.getTrailerUrl(),
                    movieRequest.getDescription(), movieRequest.getMovieType(), movieRequest.getMoviePriority(),
                    movieRequest.getIsFeatured(),movieRequest.getStartDate(),movieRequest.getEndDate()
            );
        } else if (object instanceof Movie) {
            Movie movie = (Movie) object;
            return new MovieRequest(
                    movie.getMovieName(), movie.getMovieCast(),
                    movie.getGenre(), movie.getBannerUrl(), movie.getIsFeatured(),movie.getTrailerUrl(),
                    movie.getDescription(), movie.getMovieType(), movie.getStartDate(), movie.getEndDate(), movie.getMoviePriority()
            );
        } else {
            return null;
        }
    }
}