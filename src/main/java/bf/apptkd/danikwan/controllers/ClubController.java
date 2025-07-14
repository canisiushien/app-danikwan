package bf.apptkd.danikwan.controllers;

import bf.apptkd.danikwan.exceptions.CustomException;
import bf.apptkd.danikwan.services.ClubService;
import bf.apptkd.danikwan.services.dto.ClubDTO;
import bf.apptkd.danikwan.utils.HeaderUtil;
import bf.apptkd.danikwan.utils.PaginationUtil;
import bf.apptkd.danikwan.utils.ResponseUtil;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

/**
 * @author Canisius <canisiushien@gmail.com>
 * @created 14/07/2025 at 17:57
 */
@Slf4j
@RestController
@RequestMapping(path = "/api/danikwan/clubs")
public class ClubController {
    private static final String ENTITY_NAME = "CLUB";

    @Value("${spring.application.name}")
    private String applicationName;

    private final ClubService clubService;

    public ClubController(ClubService clubService) {
        this.clubService = clubService;
    }

    /**
     * AJOUT D'UN CLUB
     *
     * @param data
     * @return
     * @throws URISyntaxException
     */
    @PostMapping(path = "/add")
    public ResponseEntity<ClubDTO> create(@Valid @RequestBody ClubDTO data) throws URISyntaxException {
        ClubDTO result = clubService.ajouter(data);
        return ResponseEntity.created(new URI("/api/api/danikwan/clubs/" + result.getId()))
                .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME,
                        result.getId().toString()))
                .body(result);
    }

    /**
     * MODIFICATION D'UN CLUB
     *
     * @param data
     * @return
     * @throws URISyntaxException
     */
    @PutMapping(path = "/edit")
    public ResponseEntity<ClubDTO> update(@Valid @RequestBody ClubDTO data) throws URISyntaxException {
        if (data.getId() == null) {
            throw new CustomException("Aucun Id dans " + ENTITY_NAME + ".");
        }
        ClubDTO result = clubService.modifier(data);
        return ResponseEntity.ok()
                .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME,
                        result.getId().toString()))
                .body(result);
    }

    /**
     * CONSULTATION D'UN CLUB
     *
     * @param id
     * @return
     */
    @GetMapping(path = "/view/{id}")
    public ResponseEntity<ClubDTO> get(@PathVariable Long id) {
        Optional<ClubDTO> result = clubService.consulter(id);
        return ResponseUtil.wrapOrNotFound(result);
    }

    /**
     * LISTE DES CLUBS
     *
     * @return
     */
    @GetMapping(path = "/view/liste")
    public ResponseEntity<List<ClubDTO>> findAll() {
        List<ClubDTO> result = clubService.lister();
        return ResponseEntity.ok().body(result);
    }

    /**
     * LISTE PAGINEE DES CLUBS
     *
     * @param pageable
     * @return
     */
    @GetMapping(path = "/view")
    public ResponseEntity<List<ClubDTO>> findAll(Pageable pageable) {
        Page<ClubDTO> result = clubService.listerPaginee( pageable);
        HttpHeaders headers = PaginationUtil.getHeaders(result);
        return new ResponseEntity<>(result.getContent(), headers, HttpStatus.OK);
    }
}
