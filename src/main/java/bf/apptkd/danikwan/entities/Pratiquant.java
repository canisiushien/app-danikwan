package bf.apptkd.danikwan.entities;

import bf.apptkd.danikwan.enums.MaturiteEnum;
import bf.apptkd.danikwan.enums.SexeEnum;
import bf.apptkd.danikwan.enums.StatutPratiquant;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

/**
 * Pour les membres des clubs
 *
 * @author Canisius <canisiushien@gmail.com>
 * @created 14/07/2025 at 15:20
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(schema = "public", name = "pratiquant")
public class Pratiquant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String code; //identifiant auto generée

    private String nom;

    private String prenom;

    private String lieuNaissance;

    private Date dateNaissance;

    private String telephone;

    private SexeEnum sexe;

    private MaturiteEnum maturite;

    private StatutPratiquant statut;

    private Date dateAdhesion; //????????????gerer les frais d'adhesion dans cotisationCollecte

    @ManyToOne
    private Club club; //s'inscrit dans quel club ?

    @ManyToOne
    private Grade gradeActuel;
}
