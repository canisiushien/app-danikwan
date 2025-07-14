package bf.apptkd.danikwan.controllers;

import bf.apptkd.danikwan.exceptions.CustomException;
import bf.apptkd.danikwan.services.TarifPratiquantService;
import bf.apptkd.danikwan.services.dto.TarifPratiquantDTO;
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
 * @created 14/07/2025 at 18:30
 */
@Slf4j
@RestController
@RequestMapping(path = "/api/danikwan/tarifs-pratiquants")
public class TarifPratiquantController {
    private static final String ENTITY_NAME = "TARIF-PRATIQUANT";

    @Value("${spring.application.name}")
    private String applicationName;

    private final TarifPratiquantService tarifPratiquantService;


    public TarifPratiquantController(TarifPratiquantService tarifPratiquantService) {
        this.tarifPratiquantService = tarifPratiquantService;
    }

    /**
     * AJOUT D'UN TARIF-PRATIQUANT
     *
     * @param data
     * @return
     * @throws URISyntaxException
     */
    @PostMapping(path = "/add")
    public ResponseEntity<TarifPratiquantDTO> create(@Valid @RequestBody TarifPratiquantDTO data) throws URISyntaxException {
        TarifPratiquantDTO result = tarifPratiquantService.ajouter(data);
        return ResponseEntity.created(new URI("/api/api/danikwan/tarifs-pratiquants/" + result.getId()))
                .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME,
                        result.getId().toString()))
                .body(result);
    }

    /**
     * MODIFICATION D'UN TARIF-PRATIQUANT
     *
     * @param data
     * @return
     * @throws URISyntaxException
     */
    @PutMapping(path = "/edit")
    public ResponseEntity<TarifPratiquantDTO> update(@Valid @RequestBody TarifPratiquantDTO data) throws URISyntaxException {
        if (data.getId() == null) {
            throw new CustomException("Aucun Id dans " + ENTITY_NAME + ".");
        }
        TarifPratiquantDTO result = tarifPratiquantService.modifier(data);
        return ResponseEntity.ok()
                .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME,
                        result.getId().toString()))
                .body(result);
    }

    /**
     * CONSULTATION D'UN TARIF-PRATIQUANT
     *
     * @param id
     * @return
     */
    @GetMapping(path = "/view/{id}")
    public ResponseEntity<TarifPratiquantDTO> get(@PathVariable Long id) {
        Optional<TarifPratiquantDTO> result = tarifPratiquantService.consulter(id);
        return ResponseUtil.wrapOrNotFound(result);
    }

    /**
     * LISTE DES TARIFS-PRATIQUANTS
     *
     * @return
     */
    @GetMapping(path = "/view/liste")
    public ResponseEntity<List<TarifPratiquantDTO>> findAll() {
        List<TarifPratiquantDTO> result = tarifPratiquantService.lister();
        return ResponseEntity.ok().body(result);
    }

    /**
     * LISTE PAGINEE DES TARIFS-PRATIQUANTS
     *
     * @param pageable
     * @return
     */
    @GetMapping(path = "/view")
    public ResponseEntity<List<TarifPratiquantDTO>> findAll(Pageable pageable) {
        Page<TarifPratiquantDTO> result = tarifPratiquantService.listerPaginee( pageable);
        HttpHeaders headers = PaginationUtil.getHeaders(result);
        return new ResponseEntity<>(result.getContent(), headers, HttpStatus.OK);
    }
}
