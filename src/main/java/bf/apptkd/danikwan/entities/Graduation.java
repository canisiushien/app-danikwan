package bf.apptkd.danikwan.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

/**
 * Pour les historiques de sexamens et grades
 *
 * @author Canisius <canisiushien@gmail.com>
 * @created 14/07/2025 at 15:44
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(schema = "public", name = "graduation")
public class Graduation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date dateAdmission; //date de validation de resultat de l'examen de grade.

    private boolean admis; //admis = true et ajourné = false

    @ManyToOne
    private Grade gradeExamine;

    @ManyToOne
    private Examen examen;

    @ManyToOne
    private Pratiquant pratiquant;
}
