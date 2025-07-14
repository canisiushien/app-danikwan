package bf.apptkd.danikwan.services;

import bf.apptkd.danikwan.services.dto.ClubDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

/**
 * @author Canisius <canisiushien@gmail.com>
 * @created 14/07/2025 at 16:09
 */
public interface ClubService {

    ClubDTO ajouter(ClubDTO data);

    ClubDTO modifier(ClubDTO data);

    Optional<ClubDTO> consulter(Long id);

    List<ClubDTO> lister();

    Page<ClubDTO> listerPaginee(Pageable pageable);
}
