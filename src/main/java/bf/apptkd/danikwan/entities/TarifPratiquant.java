package bf.apptkd.danikwan.entities;

import bf.apptkd.danikwan.enums.MaturiteEnum;
import jakarta.persistence.*;
import lombok.*;

/**
 * Pour les tarifs de cotisations mensuelles des pratiquants
 *
 * @author Canisius <canisiushien@gmail.com>
 * @created 14/07/2025 at 15:00
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(schema = "public", name = "tarif_pratiquant")
public class TarifPratiquant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private MaturiteEnum maturite;

    private double montant;
}
