package bf.apptkd.danikwan.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

/**
 * Pour les info du club
 *
 * @author Canisius <canisiushien@gmail.com>
 * @created 14/07/2025 at 15:26
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(schema = "public", name = "club")
public class Club {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String denomination;

    @Column(unique = true)
    private String sigle;

    private String lieu; //ville, secteur, quartier

    private Date dateOuverture;

    private String codeMS;

    private String nomCompletMS; //nom prenom du maitre de salle

    private String gradeMS;

    private String telephoneMS;

    private String emailMS;

    private String nomCompletPresident;

    private String telephonePresident;

    private String emailPresident;

}
