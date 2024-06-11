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
@Table(name = "career")
@Entity(name = "career")
public class CareerEntity {
//컬럼 userId지우기
    @Id
    private int careereIndex;
    private String useremail;
    private String endstart;
    private String companyname;
    private String careerposion;
}
