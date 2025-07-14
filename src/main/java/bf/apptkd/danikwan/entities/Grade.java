package bf.apptkd.danikwan.entities;

import jakarta.persistence.*;
import lombok.*;

/**
 * Pour les differents grades
 *
 * @author Canisius <canisiushien@gmail.com>
 * @created 14/07/2025 at 15:15
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(schema = "public", name = "grade")
public class Grade {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String grade;

    private String ceinture;
}
