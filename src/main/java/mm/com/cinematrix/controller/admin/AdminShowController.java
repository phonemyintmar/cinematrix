package mm.com.cinematrix.controller.admin;

import mm.com.cinematrix.business.adminBusiness.movie.IMovieBusiness;
import mm.com.cinematrix.business.dto.MovieRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/admin")
@CrossOrigin
public class AdminShowController {
    private final IMovieBusiness iMovieBusiness;

    public AdminShowController(IMovieBusiness iMovieBusiness) {
        this.iMovieBusiness = iMovieBusiness;
    }

    @PostMapping("/movie")
    public ResponseEntity<?> addMovie(@RequestBody @Valid MovieRequest movieRequest) {
        return iMovieBusiness.addMovie(movieRequest);
    }

    @GetMapping("/movie")
    public ResponseEntity<?> getAllMovies(
            @RequestParam(name = "search", required = false) String movieName,
            @RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
            @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize
    ) {
        return iMovieBusiness.getMovies(movieName, pageNo, pageSize);
    }

    @GetMapping("/movie/{movieId}/get")
    public ResponseEntity<?> getMovieById(@PathVariable String movieId) {
        return iMovieBusiness.getMovieById(movieId);
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
