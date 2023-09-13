package mm.com.cinematrix.db.repo;

import mm.com.cinematrix.db.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepo extends JpaRepository<Movie, String> {
    Optional<Movie> findByMovieName(String name);
    Optional<Movie> findByMovieId(String id);
    @Query(value = "select * from cn_movie where movie_name like %:movieName%", nativeQuery = true)
    List<Movie> searchMovie(@Param("movieName") String movieName);
}
