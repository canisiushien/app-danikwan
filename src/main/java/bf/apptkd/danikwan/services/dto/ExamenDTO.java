package bf.apptkd.danikwan.services.dto;

import lombok.Data;

import java.util.Date;

/**
 * @author Canisius <canisiushien@gmail.com>
 * @created 14/07/2025 at 16:26
 */
@Data
public class ExamenDTO {

    private Long id;

    private Date dateExamen;

    private String lieuExamen;

    private String examinateur1;

    private String examinateur2;

    private String examinateur3;

    private ClubDTO club;
}
