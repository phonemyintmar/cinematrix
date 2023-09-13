package mm.com.cinematrix.business.adminBusiness.movie;

import mm.com.cinematrix.business.dto.MovieRequest;
import org.springframework.http.ResponseEntity;

public interface IMovieBusiness {
    ResponseEntity<?> addMovie(MovieRequest movieRequest);

    ResponseEntity<?> getMovies(String name, int pageNo, int pageSize);

    ResponseEntity<?> getMovieById(String movieId);

    ResponseEntity<?> updateMovie(MovieRequest movieRequest, String movieId);

    ResponseEntity<?> deleteMovie(String movieId);
}
