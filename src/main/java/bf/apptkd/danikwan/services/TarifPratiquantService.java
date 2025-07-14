package bf.apptkd.danikwan.services;

import bf.apptkd.danikwan.services.dto.ExamenDTO;
import bf.apptkd.danikwan.services.dto.TarifPratiquantDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

/**
 * @author Canisius <canisiushien@gmail.com>
 * @created 14/07/2025 at 16:34
 */
public interface TarifPratiquantService {

    TarifPratiquantDTO ajouter(TarifPratiquantDTO data);

    TarifPratiquantDTO modifier(TarifPratiquantDTO data);

    Optional<TarifPratiquantDTO> consulter(Long id);

    List<TarifPratiquantDTO> lister();

    Page<TarifPratiquantDTO> listerPaginee(Pageable pageable);
}
