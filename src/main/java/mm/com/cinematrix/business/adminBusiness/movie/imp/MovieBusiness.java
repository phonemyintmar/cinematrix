package mm.com.cinematrix.business.adminBusiness.movie.imp;

import com.pm.ResponseUtil;
import lombok.extern.slf4j.Slf4j;
import mm.com.cinematrix.business.BaseBusiness;
import mm.com.cinematrix.business.adminBusiness.movie.IMovieBusiness;
import mm.com.cinematrix.business.dto.MovieRequest;
import mm.com.cinematrix.db.model.Movie;
import mm.com.cinematrix.db.repo.MovieRepo;
import mm.com.cinematrix.util.CinematrixResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class MovieBusiness extends BaseBusiness implements IMovieBusiness {
    private final MovieRepo movieRepo;

    public MovieBusiness(MovieRepo movieRepo) {
        this.movieRepo = movieRepo;
    }

    @Override
    public ResponseEntity<?> addMovie(MovieRequest movieRequest) {
        try {
            movieRepo.save((Movie) changeMovieRequest(movieRequest));
        } catch (Exception e) {
            log.info("Error : " + e);
            return ResponseUtil.on5xxError();
        }
        return ResponseUtil.onDefaultSuccess(movieRequest);
    }

    @Override
    public ResponseEntity<?> getAllMovies() {
        List<Movie> movies = movieRepo.findAll();
        return ResponseUtil.onDefaultSuccess(movies);
    }

    @Override
    public ResponseEntity<?> searchMovie(String name) {
        List<Movie> movies = movieRepo.searchMovie(name);
        return ResponseUtil.onDefaultSuccess(movies);
    }

    @Override
    public ResponseEntity<?> getMovieById(String movieId) {
        Optional<Movie> movieOp = movieRepo.findByMovieId(movieId);
        if (movieOp.isEmpty()) return ResponseUtil.onError(CinematrixResponse.WRONG_REQUEST, HttpStatus.NOT_FOUND);
        return ResponseUtil.onDefaultSuccess(movieOp.get());
    }

    @Override
    public ResponseEntity<?> updateMovie(MovieRequest movieRequest, String movieId) {
        Optional<Movie> movieOp = movieRepo.findByMovieId(movieId);
        if (movieOp.isEmpty()) return ResponseUtil.onError(CinematrixResponse.WRONG_REQUEST, HttpStatus.NOT_FOUND);

        Movie movie = movieOp.get();

        movie.setMovieName(movieRequest.getMovieName());
        movie.setMovieCast(movieRequest.getMovieCast());
        movie.setMoviePriority(movieRequest.getMoviePriority());
        movie.setMovieType(movieRequest.getMovieType());
        movie.setGenre(movieRequest.getGenre());
        movie.setBannerUrl(movieRequest.getBannerUrl());
        movie.setTrailerUrl(movieRequest.getTrailerUrl());
        movie.setDescription(movieRequest.getDescription());

        try {
            movieRepo.save(movie);
        } catch (Exception e) {
            log.info("Error : " + e);
            return ResponseUtil.on5xxError();
        }

        return ResponseUtil.onDefaultSuccess(movieRequest);
    }

    @Override
    public ResponseEntity<?> deleteMovie(String movieId) {
        Optional<Movie> movieOp = movieRepo.findByMovieId(movieId);
        if (movieOp.isEmpty()) return ResponseUtil.onError(CinematrixResponse.WRONG_REQUEST, HttpStatus.NOT_FOUND);
        try {
            movieRepo.delete(movieOp.get());
        } catch (Exception e) {
            log.info("Error : " + e);
            return ResponseUtil.on5xxError();
        }
        return ResponseUtil.onDefaultSuccess("Movie Deleted!");
    }
}
