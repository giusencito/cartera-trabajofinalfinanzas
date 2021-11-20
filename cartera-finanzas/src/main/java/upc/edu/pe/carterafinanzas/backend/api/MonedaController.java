package upc.edu.pe.carterafinanzas.backend.api;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



import upc.edu.pe.carterafinanzas.backend.Resource.Moneda.CreateMonedaResource;
import upc.edu.pe.carterafinanzas.backend.Resource.Moneda.MonedaResource;
import upc.edu.pe.carterafinanzas.backend.Resource.Moneda.UpdateMonedaResource;

import upc.edu.pe.carterafinanzas.backend.domain.model.entity.Moneda;
import upc.edu.pe.carterafinanzas.backend.domain.service.MonedaService;
import upc.edu.pe.carterafinanzas.backend.mapping.MonedaMapper;


@RestController
@RequestMapping("/api/v1")
public class MonedaController {


    @Autowired
    private MonedaService monedaService;

    @Autowired
    private MonedaMapper mapper;

    @Autowired
    private ModelMapper mapping;




    @GetMapping("/monedas")
    public Page<MonedaResource> getAllForumComments(Pageable pageable) {
        return mapper.modelListToPage(monedaService.getAll(), pageable);
    }

    @GetMapping("/monedas/{monedaId}")
    public MonedaResource getForumCommentById(@PathVariable("monedaId") Long monedaId) {
        return mapper.toResource(monedaService.getById(monedaId));
    }
    @PutMapping("/monedas/{monedaId}")
    public MonedaResource updateForumComment(@PathVariable Long monedaId, @RequestBody UpdateMonedaResource request) {
        return mapper.toResource(monedaService.update(monedaId, mapper.toModel(request)));
    }

    @DeleteMapping("/monedas/{monedaId}")
    public ResponseEntity<?> deleteForumComment(@PathVariable Long monedaId) {
        return monedaService.delete(monedaId);
    }
    @PostMapping("/emisores/{emisorId}/valores/{valorId}/tipodemonedas/{tipodemonedaId}/carteras/{carteraId}/monedas")
    public MonedaResource createForumComment(@PathVariable Long emisorId, @PathVariable Long valorId, @PathVariable Long tipodemonedaId, @PathVariable Long carteraId,@RequestBody CreateMonedaResource request) {
        Moneda forumcomment = mapping.map(request, Moneda.class);
        return mapping.map(monedaService.create(emisorId, valorId, tipodemonedaId,carteraId,forumcomment), MonedaResource.class);
    }
    @GetMapping("/emisores/{emisorId}/monedas")
    public Page<MonedaResource> getAllForumCommentsByemisorId(@PathVariable Long emisorId, Pageable pageable) {
        return mapper.modelListToPage(monedaService.findByemisorId(emisorId), pageable);
    }

    @GetMapping("/valores/{valorId}/monedas")
    public Page<MonedaResource> getAllForumCommentsByvalorId(@PathVariable Long valorId,Pageable pageable) {
        return mapper.modelListToPage(monedaService.findByvalorId(valorId), pageable);
    }

    @GetMapping("/tipodemonedas/{tipodemonedaId}/monedas")
    public Page<MonedaResource> getAllForumCommentsBytipomonedaId(@PathVariable Long tipodemonedaId,Pageable pageable) {
        return mapper.modelListToPage(monedaService.findBytipodemonedaId(tipodemonedaId), pageable);
    }

    @GetMapping("/carteras/{carteraId}/monedas")
    public Page<MonedaResource> getAllForumCommentsBycarteraId(@PathVariable Long carteraId,Pageable pageable) {
        return mapper.modelListToPage(monedaService.findByCarteraId(carteraId), pageable);
    }









}
