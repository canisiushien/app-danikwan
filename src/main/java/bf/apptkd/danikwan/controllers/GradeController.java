package bf.apptkd.danikwan.controllers;

import bf.apptkd.danikwan.exceptions.CustomException;
import bf.apptkd.danikwan.services.GradeService;
import bf.apptkd.danikwan.services.dto.GradeDTO;
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
 * @created 14/07/2025 at 18:21
 */
@Slf4j
@RestController
@RequestMapping(path = "/api/danikwan/grades")
public class GradeController {
    private static final String ENTITY_NAME = "GRADE";

    @Value("${spring.application.name}")
    private String applicationName;

    private final GradeService gradeService;

    public GradeController(GradeService gradeService) {
        this.gradeService = gradeService;
    }

    /**
     * AJOUT D'UN GRADE
     *
     * @param data
     * @return
     * @throws URISyntaxException
     */
    @PostMapping(path = "/add")
    public ResponseEntity<GradeDTO> create(@Valid @RequestBody GradeDTO data) throws URISyntaxException {
        GradeDTO result = gradeService.ajouter(data);
        return ResponseEntity.created(new URI("/api/api/danikwan/grades/" + result.getId()))
                .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME,
                        result.getId().toString()))
                .body(result);
    }

    /**
     * MODIFICATION D'UN GRADE
     *
     * @param data
     * @return
     * @throws URISyntaxException
     */
    @PutMapping(path = "/edit")
    public ResponseEntity<GradeDTO> update(@Valid @RequestBody GradeDTO data) throws URISyntaxException {
        if (data.getId() == null) {
            throw new CustomException("Aucun Id dans " + ENTITY_NAME + ".");
        }
        GradeDTO result = gradeService.modifier(data);
        return ResponseEntity.ok()
                .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME,
                        result.getId().toString()))
                .body(result);
    }

    /**
     * CONSULTATION D'UN GRADE
     *
     * @param id
     * @return
     */
    @GetMapping(path = "/view/{id}")
    public ResponseEntity<GradeDTO> get(@PathVariable Long id) {
        Optional<GradeDTO> result = gradeService.consulter(id);
        return ResponseUtil.wrapOrNotFound(result);
    }

    /**
     * LISTE DES GRADES
     *
     * @return
     */
    @GetMapping(path = "/view/liste")
    public ResponseEntity<List<GradeDTO>> findAll() {
        List<GradeDTO> result = gradeService.lister();
        return ResponseEntity.ok().body(result);
    }

    /**
     * LISTE PAGINEE DES GRADES
     *
     * @param pageable
     * @return
     */
    @GetMapping(path = "/view")
    public ResponseEntity<List<GradeDTO>> findAll(Pageable pageable) {
        Page<GradeDTO> result = gradeService.listerPaginee( pageable);
        HttpHeaders headers = PaginationUtil.getHeaders(result);
        return new ResponseEntity<>(result.getContent(), headers, HttpStatus.OK);
    }
}
