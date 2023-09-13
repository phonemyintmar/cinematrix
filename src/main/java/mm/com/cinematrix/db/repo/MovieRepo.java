package mm.com.cinematrix.db.repo;

import mm.com.cinematrix.db.model.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MovieRepo extends JpaRepository<Movie, String> {
    Optional<Movie> findByMovieId(String id);
    @Query(value = "select * from cn_movie where (:movieName is null or movie_name like %:movieName%)",
            countQuery = "select count(*) from cn_movie where (:movieName is null or movie_name like %:movieName%)",nativeQuery = true)
    Page<Movie> getMovies(@Param("movieName") String movieName, Pageable pageable);
}
