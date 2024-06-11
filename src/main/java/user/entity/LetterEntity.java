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
@Entity(name = "letter")
@Table(name = "letter")
public class LetterEntity {

    @Id
    private String useremail;
    private String lettertype;
    private String lettertitle;
    private String lettercontent;

}
