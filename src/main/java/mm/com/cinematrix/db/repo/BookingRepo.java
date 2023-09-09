package mm.com.cinematrix.db.repo;

import mm.com.cinematrix.db.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepo extends JpaRepository<Booking, String> {
}
