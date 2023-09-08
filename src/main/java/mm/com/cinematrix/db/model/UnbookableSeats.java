package mm.com.cinematrix.db.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UnbookableSeats { // ?
    private String reason;
    private List<String> seats;
}
