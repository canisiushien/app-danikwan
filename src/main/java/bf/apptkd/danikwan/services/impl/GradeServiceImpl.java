package bf.apptkd.danikwan.services.impl;

import bf.apptkd.danikwan.entities.Grade;
import bf.apptkd.danikwan.exceptions.CustomException;
import bf.apptkd.danikwan.repositories.GradeRepository;
import bf.apptkd.danikwan.services.GradeService;
import bf.apptkd.danikwan.services.dto.GradeDTO;
import bf.apptkd.danikwan.services.mapper.GradeMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Canisius <canisiushien@gmail.com>
 * @created 14/07/2025 at 17:35
 */
@Slf4j
@Service
public class GradeServiceImpl implements GradeService {

    private final GradeRepository gradeRepository;

    private final GradeMapper gradeMapper;

    public GradeServiceImpl(GradeRepository gradeRepository, GradeMapper gradeMapper) {
        this.gradeRepository = gradeRepository;
        this.gradeMapper = gradeMapper;
    }


    /**
     * @param data
     * @return
     */
    @Override
    public GradeDTO ajouter(GradeDTO data) {
        log.info("Ajout de grade : {}", data);
        Grade response = gradeMapper.toEntity(data);
        response = gradeRepository.save(response);
        return gradeMapper.toDTO(response);
    }

    /**
     * @param data
     * @return
     */
    @Override
    public GradeDTO modifier(GradeDTO data) {
        log.info("Modifier de grade : {}", data);
        Grade response = gradeMapper.toEntity(data);
        response = gradeRepository.save(response);
        return gradeMapper.toDTO(response);
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Optional<GradeDTO> consulter(Long id) {
        log.info("Consulter grade : {}", id);
        Grade response = gradeRepository.findById(id).orElseThrow(() -> new CustomException("Le grade n'existe pas."));
        return Optional.ofNullable(gradeMapper.toDTO(response));
    }

    /**
     * @return
     */
    @Override
    public List<GradeDTO> lister() {
        log.info("Lister les grades");
        return gradeRepository.findAll().stream().map(gradeMapper::toDTO).collect(Collectors.toList());
    }

    /**
     * @param pageable
     * @return
     */
    @Override
    public Page<GradeDTO> listerPaginee(Pageable pageable) {
        log.info("Lister paginée des grades");
        return gradeRepository.findAll(pageable).map(gradeMapper::toDTO);
    }
}
