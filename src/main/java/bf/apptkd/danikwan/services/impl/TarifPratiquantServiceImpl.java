package bf.apptkd.danikwan.services.impl;

import bf.apptkd.danikwan.entities.TarifPratiquant;
import bf.apptkd.danikwan.exceptions.CustomException;
import bf.apptkd.danikwan.repositories.TarifPratiquantRepository;
import bf.apptkd.danikwan.services.TarifPratiquantService;
import bf.apptkd.danikwan.services.dto.TarifPratiquantDTO;
import bf.apptkd.danikwan.services.mapper.TarifPratiquantMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Canisius <canisiushien@gmail.com>
 * @created 14/07/2025 at 17:50
 */
@Slf4j
@AllArgsConstructor
@Service
public class TarifPratiquantServiceImpl implements TarifPratiquantService {

    private final TarifPratiquantRepository tarifPratiquantRepository;

    private final TarifPratiquantMapper tarifPratiquantMapper;

    /**
     * @param data
     * @return
     */
    @Override
    public TarifPratiquantDTO ajouter(TarifPratiquantDTO data) {
        log.info("Ajout de tarif pratiquant : {}", data);
        TarifPratiquant response = tarifPratiquantMapper.toEntity(data);
        response = tarifPratiquantRepository.save(response);
        return tarifPratiquantMapper.toDTO(response);
    }

    /**
     * @param data
     * @return
     */
    @Override
    public TarifPratiquantDTO modifier(TarifPratiquantDTO data) {
        log.info("Modifier de tarif pratiquant : {}", data);
        TarifPratiquant response = tarifPratiquantMapper.toEntity(data);
        response = tarifPratiquantRepository.save(response);
        return tarifPratiquantMapper.toDTO(response);
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Optional<TarifPratiquantDTO> consulter(Long id) {
        log.info("Consulter tarif pratiquant : {}", id);
        TarifPratiquant response = tarifPratiquantRepository.findById(id).orElseThrow(() -> new CustomException("Le tarif n'existe pas."));
        return Optional.ofNullable(tarifPratiquantMapper.toDTO(response));
    }

    /**
     * @return
     */
    @Override
    public List<TarifPratiquantDTO> lister() {
        log.info("Lister les tarifs pratiquant");
        return tarifPratiquantRepository.findAll().stream().map(tarifPratiquantMapper::toDTO).collect(Collectors.toList());
    }

    /**
     * @param pageable
     * @return
     */
    @Override
    public Page<TarifPratiquantDTO> listerPaginee(Pageable pageable) {
        log.info("Lister paginée des tarifs pratiquant");
        return tarifPratiquantRepository.findAll(pageable).map(tarifPratiquantMapper::toDTO);
    }
}
