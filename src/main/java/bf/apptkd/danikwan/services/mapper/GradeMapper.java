package bf.apptkd.danikwan.services.mapper;

import bf.apptkd.danikwan.entities.Grade;
import bf.apptkd.danikwan.services.dto.GradeDTO;
import org.mapstruct.Mapper;

/**
 * @author Canisius <canisiushien@gmail.com>
 * @created 14/07/2025 at 17:38
 */
@Mapper(componentModel = "spring")
public interface GradeMapper {
    GradeDTO toDTO(Grade data);

    Grade toEntity(GradeDTO data);
}
