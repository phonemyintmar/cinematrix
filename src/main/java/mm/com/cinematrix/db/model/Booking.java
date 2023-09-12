package mm.com.cinematrix.db.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "cn_booking")
public class Booking {
    @Id
    private String bookingId;

    private String movieId;

    private String showId;

    private String showTime;

    private String seatNumbers;

    private String movieName;

    private String screenAndTheatreName;

    private Double totalCost;

    private String userName;

    //analytics// nout pine mha pop
//    private Boolean isGuest;

    @Enumerated(EnumType.STRING)
    private BookingStatus bookingStatus;

    private String paymentType;
}
