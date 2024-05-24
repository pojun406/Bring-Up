package user.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "CV")
@Table(name = "CV")
public class CvEntity {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private int cvIndex;
    @Column(name = "CVimage")
    private String CVimage;
    @Column(name="mainCV")
    private String mainCV;
    private String education;
    private String userId;
}
