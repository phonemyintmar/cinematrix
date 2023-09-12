package mm.com.cinematrix.db.repo;

import mm.com.cinematrix.db.model.Screen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScreenRepo extends JpaRepository<Screen,String> {
}
