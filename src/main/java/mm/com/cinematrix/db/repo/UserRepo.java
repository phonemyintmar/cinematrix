package mm.com.cinematrix.db.repo;

import mm.com.cinematrix.db.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, String> {
}
