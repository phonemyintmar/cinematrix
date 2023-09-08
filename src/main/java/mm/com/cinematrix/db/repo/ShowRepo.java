package mm.com.cinematrix.db.repo;

import mm.com.cinematrix.db.model.Show;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowRepo extends JpaRepository<Show, String> {
}
