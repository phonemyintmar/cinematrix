package mm.com.cinematrix.db.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ob_screen")
@Getter
@Setter
public class Screen {
    @Id
    private String screenId;

    private String screenName;

    private String theatreId;

    private String coupleSeats;

    private String normalSeats;

    private String standardSeats;

    private String premiumSeats;

    private String bannerUrl;

    private Boolean is3dAvailable;

    private String theatreAddress;

    @JsonIgnore
    private Integer totalSeatNumbers;
}
