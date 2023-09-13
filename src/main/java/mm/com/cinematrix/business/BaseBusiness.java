package mm.com.cinematrix.business;

import lombok.extern.slf4j.Slf4j;
import mm.com.cinematrix.business.dto.MovieRequest;
import mm.com.cinematrix.db.model.Movie;
import mm.com.cinematrix.db.repo.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


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
                    movieRequest.getFeatureUrl(), movieRequest.getIsFeatured(), movieRequest.getStartDate(), movieRequest.getEndDate()
            );
        } else if (object instanceof Movie) {
            Movie movie = (Movie) object;
            return new MovieRequest(
                    movie.getMovieName(), movie.getMovieCast(),
                    movie.getGenre(), movie.getBannerUrl(), movie.getFeatureUrl(), movie.getIsFeatured(), movie.getTrailerUrl(),
                    movie.getDescription(), movie.getMovieType(), movie.getStartDate(), movie.getEndDate(), movie.getMoviePriority()
            );
        } else {
            return null;
        }
    }

    public boolean checkFeatured(MovieRequest movieRequest) {
        if (movieRequest.getIsFeatured()) {
            if (movieRequest.getFeatureUrl() != null){
                return !isValidURL(movieRequest.getFeatureUrl());
            }else {
                return true;
            }
        }
        return false;
    }

    private boolean isValidURL(String urlString) {
        String regex = "^(https?://)?([a-zA-Z0-9.-]+\\.[a-z]{2,6})(/\\S*)?$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(urlString);
        return matcher.matches();
    }
}