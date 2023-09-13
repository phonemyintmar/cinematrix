package mm.com.cinematrix.db.repo;

import mm.com.cinematrix.db.model.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepo extends JpaRepository<Movie, String> {
    Optional<Movie> findByMovieId(String id);

    @Query(value = "SELECT * FROM cn_movie WHERE is_featured = true", nativeQuery = true)
    List<Movie> getFeatureMovies();

    @Query(value = "SELECT * FROM cn_movie \n" +
            "WHERE \n" +
            "    (:date IS NULL OR (start_date <= to_date(:date, 'YYYY-MM-DD') AND end_date >= to_date(:date, 'YYYY-MM-DD'))\n" +
            "    AND :movieName IS NULL OR movie_name LIKE %:movieName%\n" +
            "    AND :type IS NULL OR movie_type = :type)\n",
            countQuery = "SELECT COUNT(*) FROM cn_movie \n" +
                    "WHERE \n" +
                    "    (:date IS NULL OR start_date <= to_date(:date, 'YYYY-MM-DD') AND end_date >= to_date(:date, 'YYYY-MM-DD')\n" +
                    "    AND :movieName IS NULL OR movie_name LIKE %:movieName%\n" +
                    "    AND :type IS NULL OR movie_type = :type)\n", nativeQuery = true)
    Page<Movie> getMovies(@Param("date") String date, @Param("movieName") String movieName, @Param("type") String type, Pageable pageable);
}
