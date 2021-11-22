package upc.edu.pe.carterafinanzas.backend.api;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import upc.edu.pe.carterafinanzas.backend.Resource.Comitente.ComitenteResource;
import upc.edu.pe.carterafinanzas.backend.Resource.Comitente.CreateComitenteResource;
import upc.edu.pe.carterafinanzas.backend.Resource.Comitente.UpdateComitenteResource;
import upc.edu.pe.carterafinanzas.backend.domain.model.entity.Comitente;
import upc.edu.pe.carterafinanzas.backend.domain.service.ComitenteService;
import upc.edu.pe.carterafinanzas.backend.mapping.ComitenteMapper;

@RestController
@RequestMapping("/api/v1")
public class ComitenteController {

/*
    @Autowired
    private ComitenteService comitenteService;

    @Autowired
    private ComitenteMapper mapper;

    @Autowired
    private ModelMapper mapping;


    @GetMapping("/comitentes")
    public Page<ComitenteResource> getAllForumComments(Pageable pageable) {
        return mapper.modelListToPage(comitenteService.getAll(), pageable);
    }

    @GetMapping("/comitentes/{comitenteId}")
    public ComitenteResource getForumCommentById(@PathVariable("comitenteId") Long comitenteId) {
        return mapper.toResource(comitenteService.getById(comitenteId));
    }

    @PostMapping("/emisores/{emisorId}/valores/{valorId}/resultadocomitentes/{resultadocomitenteId}/comitentes")
    public ComitenteResource createForumComment(@PathVariable Long emisorId, @PathVariable Long valorId, @PathVariable Long resultadocomitenteId,@RequestBody CreateComitenteResource request) {
        Comitente forumcomment = mapping.map(request, Comitente.class);
        return mapping.map(comitenteService.create(emisorId, valorId, resultadocomitenteId,forumcomment), ComitenteResource.class);
    }
    @PutMapping("/comitentes/{comitenteId}")
    public ComitenteResource updateForumComment(@PathVariable Long comitenteId, @RequestBody UpdateComitenteResource request) {
        return mapper.toResource(comitenteService.update(comitenteId, mapper.toModel(request)));
    }

    @DeleteMapping("/comitentes/{comitenteId}")
    public ResponseEntity<?> deleteForumComment(@PathVariable Long forumcommentId) {
        return comitenteService.delete(forumcommentId);
    }
    @GetMapping("/emisores/{emisorId}/comitentes")
    public Page<ComitenteResource> getAllForumCommentsByemisorId(@PathVariable Long emisorId,Pageable pageable) {
        return mapper.modelListToPage(comitenteService.findByemisorId(emisorId), pageable);
    }

    @GetMapping("/valores/{valorId}/comitentes")
    public Page<ComitenteResource> getAllForumCommentsByvalorId(@PathVariable Long valorId,Pageable pageable) {
        return mapper.modelListToPage(comitenteService.findByvalorId(valorId), pageable);
    }
    @GetMapping("/resultadocomitentes/{resultadocomitenteId}/comitentes")
    public Page<ComitenteResource> getAllForumCommentsByresultadoComitentesId(@PathVariable Long resultadocomitenteId,Pageable pageable) {
        return mapper.modelListToPage(comitenteService.findByresultadocomitenteId(resultadocomitenteId), pageable);
    }


*/


}
