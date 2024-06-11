package user.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "usermembership")
@Table(name = "usermembership")
public class UsermembershipEntity {

    @Id
    private String usereail;
    private String startdate;
    private String period;

}
