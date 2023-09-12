package mm.com.cinematrix.db.repo;

import mm.com.cinematrix.db.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepo extends JpaRepository<Movie, String> {
}
