package mm.com.cinematrix.controller.user;

import lombok.extern.slf4j.Slf4j;
import mm.com.cinematrix.business.commonBusiness.ICommonBusiness;
import mm.com.cinematrix.db.model.MovieType;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/user")
@CrossOrigin
@Slf4j
public class UserMovieController {
    private final ICommonBusiness iCommonBusiness;

    public UserMovieController(ICommonBusiness iCommonBusiness) {
        this.iCommonBusiness = iCommonBusiness;
    }

    @GetMapping("/movie")
    public ResponseEntity<?> getAllMovies(
            @RequestParam(name = "date", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
            @RequestParam(name = "movieName", required = false) String movieName,
            @RequestParam(name = "type", required = false) MovieType movieType,
            @RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
            @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize
    ) {
        return iCommonBusiness.getMovies(date, movieName, movieType, pageNo, pageSize);
    }

    @GetMapping("/movie/feature")
    public ResponseEntity<?> getFeatureMovies() {
        return iCommonBusiness.getFeatureMovies();
    }

    @GetMapping("/movie/{movieId}")
    public ResponseEntity<?> getMovieById(@PathVariable String movieId) {
        return iCommonBusiness.getMovieById(movieId);
    }
}
