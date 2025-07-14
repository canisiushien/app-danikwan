package bf.apptkd.danikwan.services.mapper;

import bf.apptkd.danikwan.entities.Club;
import bf.apptkd.danikwan.services.dto.ClubDTO;
import org.mapstruct.Mapper;

/**
 * @author Canisius <canisiushien@gmail.com>
 * @created 14/07/2025 at 16:59
 */
@Mapper(componentModel = "spring")
public interface ClubMapper {
    ClubDTO toDTO(Club data);

    Club toEntity(ClubDTO data);
}
