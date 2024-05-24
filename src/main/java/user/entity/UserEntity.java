package user.entity;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {
    @Id
    private String useremail;
    private String userpassword;
    private String username;
    private String useraddress;
    private String userphonenumber;
    private String userbrithday;
    private boolean freelancer;
}
