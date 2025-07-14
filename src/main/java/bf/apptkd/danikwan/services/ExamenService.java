package bf.apptkd.danikwan.services;

import bf.apptkd.danikwan.services.dto.ExamenDTO;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

/**
 * @author Canisius <canisiushien@gmail.com>
 * @created 14/07/2025 at 16:25
 */
public interface ExamenService {

    ExamenDTO ajouter(ExamenDTO data);

    ExamenDTO modifier(ExamenDTO data);

    Optional<ExamenDTO> consulter(Long id);

    List<ExamenDTO> lister();

    Page<ExamenDTO> listerPaginee(Pageable pageable);
}
