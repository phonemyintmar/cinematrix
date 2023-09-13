package mm.com.cinematrix.business.commonBusiness;

import mm.com.cinematrix.db.model.MovieType;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;

public interface ICommonBusiness {
    ResponseEntity<?> getMovies(LocalDate date, String movieName, MovieType movieType, int pageNo, int pageSize);

    ResponseEntity<?> getMovieById(String movieId);
    ResponseEntity<?> getFeatureMovies();

}
