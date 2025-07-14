package bf.apptkd.danikwan.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

/**
 * Pour les examen de grade ou passation
 *
 * @author Canisius <canisiushien@gmail.com>
 * @created 14/07/2025 at 15:53
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(schema = "public", name = "examen")
public class Examen {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date dateExamen;

    private String lieuExamen;

    private String examinateur1;

    private String examinateur2;

    private String examinateur3;

    @ManyToOne
    private Club club; //examen origanisé par quel club ?
}
