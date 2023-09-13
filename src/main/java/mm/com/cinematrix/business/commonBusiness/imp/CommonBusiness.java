package mm.com.cinematrix.business.commonBusiness.imp;

import com.pm.ResponseUtil;
import mm.com.cinematrix.business.commonBusiness.ICommonBusiness;
import mm.com.cinematrix.db.model.Movie;
import mm.com.cinematrix.db.model.MovieType;
import mm.com.cinematrix.db.repo.MovieRepo;
import mm.com.cinematrix.util.CinematrixResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class CommonBusiness implements ICommonBusiness {
    private final MovieRepo movieRepo;

    public CommonBusiness(MovieRepo movieRepo) {
        this.movieRepo = movieRepo;
    }

    @Override
    public ResponseEntity<?> getMovies(LocalDate date, String movieName, MovieType movieType, int pageNo, int pageSize) {
        Sort sort = Sort.by("created_date").descending();
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        Page<Movie> movies = movieRepo.getMovies(date.toString(), movieName, String.valueOf(movieType), pageable);
        return ResponseUtil.onDefaultSuccess(movies);
    }

    @Override
    public ResponseEntity<?> getMovieById(String movieId) {
        Optional<Movie> movieOp = movieRepo.findByMovieId(movieId);
        if (movieOp.isEmpty()) return ResponseUtil.onError(CinematrixResponse.WRONG_REQUEST, HttpStatus.NOT_FOUND);
        return ResponseUtil.onDefaultSuccess(movieOp.get());
    }

    @Override
    public ResponseEntity<?> getFeatureMovies() {
        List<Movie> movies = movieRepo.getFeatureMovies();
        return ResponseUtil.onDefaultSuccess(movies);
    }
}
