package mm.com.cinematrix.db.repo;

import mm.com.cinematrix.db.model.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheatreRepo extends JpaRepository<Theatre, String> {
}
