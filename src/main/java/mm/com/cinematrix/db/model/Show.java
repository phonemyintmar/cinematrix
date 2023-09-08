package mm.com.cinematrix.db.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "cn_show")
public class Show {
    @Id
    private String showId;

    private String movieId;

    private String screenId;

    private String theatreId;

    private LocalDate showDate;

    private String showTime;

    private Double coupleSeatsPrice;

    private Double normalSeatsPrice;

    private Double standardSeatsPrice;

    private Double premiumSeatsPrice;

    private Boolean is3d;

    private Integer totalAvailableSeats;

    private Integer totalTakenSeats;

    private String occupiedSeats;

    private String note;

    private String showKey;

    @JsonIgnore
    private Double totalIncome;


}
