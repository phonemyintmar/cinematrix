package mm.com.cinematrix.controller.admin;

import mm.com.cinematrix.business.adminBusiness.movie.IMovieBusiness;
import mm.com.cinematrix.business.commonBusiness.ICommonBusiness;
import mm.com.cinematrix.business.dto.MovieRequest;
import mm.com.cinematrix.db.model.MovieType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;

@RestController
@RequestMapping("/admin")
@CrossOrigin
public class AdminMovieController {
    private final IMovieBusiness iMovieBusiness;
    private final ICommonBusiness iCommonBusiness;

    public AdminMovieController(IMovieBusiness iMovieBusiness, ICommonBusiness iCommonBusiness) {
        this.iMovieBusiness = iMovieBusiness;
        this.iCommonBusiness = iCommonBusiness;
    }

    @PostMapping("/movie")
    public ResponseEntity<?> addMovie(@RequestBody @Valid MovieRequest movieRequest) {
        return iMovieBusiness.addMovie(movieRequest);
    }

    @GetMapping("/movie")
    public ResponseEntity<?> getAllMovies(
            @RequestParam(name = "date", required = false) LocalDate date,
            @RequestParam(name = "movieName", required = false) String movieName,
            @RequestParam(name = "type", required = false) MovieType movieType,
            @RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
            @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize
    ) {
        return iCommonBusiness.getMovies(date, movieName, movieType, pageNo, pageSize);
    }

    @GetMapping("/movie/{movieId}")
    public ResponseEntity<?> getMovieById(@PathVariable String movieId) {
        return iCommonBusiness.getMovieById(movieId);
    }

    @GetMapping("/movie/{movieId}/delete")
    public ResponseEntity<?> deleteById(@PathVariable String movieId) {
        return iMovieBusiness.deleteMovie(movieId);
    }

    @PostMapping("/movie/{movieName}/update")
    public ResponseEntity<?> updateMovie(@RequestBody @Valid MovieRequest movieRequest, @PathVariable("movieName") String movieName) {
        return iMovieBusiness.updateMovie(movieRequest, movieName);
    }
}
