package mm.com.cinematrix.db.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "cn_user")
public class User {

    @Id
    private String userId;

    private String userName;

    private String password;

    private Double systemPoints;

    private String userRole;
}
