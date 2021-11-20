package upc.edu.pe.carterafinanzas.backend.api;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import upc.edu.pe.carterafinanzas.backend.Resource.Descuento.CreateDescuentoResource;
import upc.edu.pe.carterafinanzas.backend.Resource.Descuento.DescuentoResource;

import upc.edu.pe.carterafinanzas.backend.Resource.Descuento.UpdateDescuentoResource;
import upc.edu.pe.carterafinanzas.backend.domain.model.entity.Descuento;
import upc.edu.pe.carterafinanzas.backend.domain.service.DescuentoService;
import upc.edu.pe.carterafinanzas.backend.mapping.DescuentoMapper;


@RestController
@RequestMapping("/api/v1")
public class DescuentoController {


    @Autowired
    private DescuentoService descuentoService;

    @Autowired
    private DescuentoMapper mapper;

    @Autowired
    private ModelMapper mapping;




    @GetMapping("/descuentos")
    public Page<DescuentoResource> getAllForumComments(Pageable pageable) {
        return mapper.modelListToPage(descuentoService.getAll(), pageable);
    }

    @GetMapping("/descuentos/{descuentoId}")
    public DescuentoResource getForumCommentById(@PathVariable("forumcommentId") Long forumcommentId) {
        return mapper.toResource(descuentoService.getById(forumcommentId));
    }

    @PostMapping("/emisores/{emisorId}/valores/{valorId}/tipodemonedas/{tipodemonedaId}/descuentos")
    public DescuentoResource createForumComment(@PathVariable Long emisorId, @PathVariable Long valorId, @PathVariable Long tipodemonedaId, @RequestBody CreateDescuentoResource request) {
        Descuento forumcomment = mapping.map(request, Descuento.class);
        return mapping.map(descuentoService.create(emisorId, valorId, tipodemonedaId,forumcomment), DescuentoResource.class);
    }
    @PutMapping("/descuentos/{descuentoId}")
    public DescuentoResource updateForumComment(@PathVariable Long descuentoId, @RequestBody UpdateDescuentoResource request) {
        return mapper.toResource(descuentoService.update(descuentoId, mapper.toModel(request)));
    }

    @DeleteMapping("/descuentos/{descuentoId}")
    public ResponseEntity<?> deleteForumComment(@PathVariable Long descuentoId) {
        return descuentoService.delete(descuentoId);
    }

    @GetMapping("/emisores/{emisorId}/descuentos")
    public Page<DescuentoResource> getAllForumCommentsByemisorId(@PathVariable Long emisorId,Pageable pageable) {
        return mapper.modelListToPage(descuentoService.findByemisorId(emisorId), pageable);
    }

    @GetMapping("/valores/{valorId}/descuentos")
    public Page<DescuentoResource> getAllForumCommentsByvalorId(@PathVariable Long valorId,Pageable pageable) {
        return mapper.modelListToPage(descuentoService.findByValorId(valorId), pageable);
    }

    @GetMapping("/tipodemonedas/{tipodemonedaId}/descuentos")
    public Page<DescuentoResource> getAllForumCommentsBytipomonedaId(@PathVariable Long tipodemonedaId,Pageable pageable) {
        return mapper.modelListToPage(descuentoService.findBytipodemonedaId(tipodemonedaId), pageable);
    }
















}
