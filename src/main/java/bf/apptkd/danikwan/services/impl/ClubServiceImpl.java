package bf.apptkd.danikwan.services.impl;

import bf.apptkd.danikwan.entities.Club;
import bf.apptkd.danikwan.exceptions.CustomException;
import bf.apptkd.danikwan.repositories.ClubRepository;
import bf.apptkd.danikwan.services.ClubService;
import bf.apptkd.danikwan.services.dto.ClubDTO;
import bf.apptkd.danikwan.services.mapper.ClubMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Canisius <canisiushien@gmail.com>
 * @created 14/07/2025 at 17:08
 */
@Slf4j
@Service
public class ClubServiceImpl implements ClubService {

    private final ClubRepository clubRepository;

    private final ClubMapper clubMapper;

    public ClubServiceImpl(ClubRepository clubRepository, ClubMapper clubMapper) {
        this.clubRepository = clubRepository;
        this.clubMapper = clubMapper;
    }

    /**
     * @param data
     * @return
     */
    @Override
    public ClubDTO ajouter(ClubDTO data) {
        log.info("Ajout de club : {}", data);
        Club club = clubMapper.toEntity(data);
        club = clubRepository.save(club);
        return clubMapper.toDTO(club);
    }

    /**
     * @param data
     * @return
     */
    @Override
    public ClubDTO modifier(ClubDTO data) {
        log.info("Modifier de club : {}", data);
        Club club = clubMapper.toEntity(data);
        club = clubRepository.save(club);
        return clubMapper.toDTO(club);
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Optional<ClubDTO> consulter(Long id) {
        log.info("Consulter club : {}", id);
        Club response = clubRepository.findById(id).orElseThrow(() -> new CustomException("Le club n'existe pas."));
        return Optional.ofNullable(clubMapper.toDTO(response));
    }

    /**
     * @return
     */
    @Override
    public List<ClubDTO> lister() {
        log.info("Lister les club");
        return clubRepository.findAll().stream().map(clubMapper::toDTO).collect(Collectors.toList());
    }

    /**
     * @param pageable
     * @return
     */
    @Override
    public Page<ClubDTO> listerPaginee(Pageable pageable) {
        log.info("Lister paginée des club");
        return clubRepository.findAll(pageable).map(clubMapper::toDTO);
    }
}
