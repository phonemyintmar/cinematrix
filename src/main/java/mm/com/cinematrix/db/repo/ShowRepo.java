package mm.com.cinematrix.db.repo;

import mm.com.cinematrix.db.model.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowRepo extends JpaRepository<Show, String> {
}
