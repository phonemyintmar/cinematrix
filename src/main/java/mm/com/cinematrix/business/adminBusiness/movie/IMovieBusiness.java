package mm.com.cinematrix.business.adminBusiness.movie;

import mm.com.cinematrix.business.dto.MovieRequest;
import mm.com.cinematrix.db.model.MovieType;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;

public interface IMovieBusiness {
    ResponseEntity<?> addMovie(MovieRequest movieRequest);

    ResponseEntity<?> updateMovie(MovieRequest movieRequest, String movieId);

    ResponseEntity<?> deleteMovie(String movieId);

}
