package mm.com.cinematrix.db.repo;

import mm.com.cinematrix.db.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepo extends JpaRepository<Booking,String> {
}
