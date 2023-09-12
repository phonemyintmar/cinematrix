package mm.com.cinematrix.db.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cn_theatre")
@Setter
@Getter
public class Theatre {
    @Id
    private String theatreId;

    private String theatreName;

    private String address;

    private String description;

    private int theatrePopularity;

    private String bannerUrl;
}
