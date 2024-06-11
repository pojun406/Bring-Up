package user.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "portfolio")
@Entity(name = "portfolio")
public class PortfolioEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int protfolioindex;
    private String useremail;
    private String portfoliotype;
    private String url;
}
