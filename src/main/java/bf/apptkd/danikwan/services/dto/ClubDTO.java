package bf.apptkd.danikwan.services.dto;

import jakarta.persistence.Column;
import lombok.Data;

import java.util.Date;

/**
 * @author Canisius <canisiushien@gmail.com>
 * @created 14/07/2025 at 18:40
 */
@Data
public class ClubDTO {

    private Long id;

    private String denomination;

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
