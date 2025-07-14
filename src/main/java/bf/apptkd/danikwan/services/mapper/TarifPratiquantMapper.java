package bf.apptkd.danikwan.services.mapper;

import bf.apptkd.danikwan.entities.TarifPratiquant;
import bf.apptkd.danikwan.services.dto.TarifPratiquantDTO;
import org.mapstruct.Mapper;

/**
 * @author Canisius <canisiushien@gmail.com>
 * @created 14/07/2025 at 17:47
 */
@Mapper(componentModel = "spring")
public interface TarifPratiquantMapper {
    TarifPratiquantDTO toDTO(TarifPratiquant data);

    TarifPratiquant toEntity(TarifPratiquantDTO data);
}
