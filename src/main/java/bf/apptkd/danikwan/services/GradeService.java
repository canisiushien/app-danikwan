package bf.apptkd.danikwan.services;

import bf.apptkd.danikwan.services.dto.GradeDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

/**
 * @author Canisius <canisiushien@gmail.com>
 * @created 14/07/2025 at 16:32
 */
public interface GradeService {

    GradeDTO ajouter(GradeDTO data);

    GradeDTO modifier(GradeDTO data);

    Optional<GradeDTO> consulter(Long id);

    List<GradeDTO> lister();

    Page<GradeDTO> listerPaginee(Pageable pageable);
}
