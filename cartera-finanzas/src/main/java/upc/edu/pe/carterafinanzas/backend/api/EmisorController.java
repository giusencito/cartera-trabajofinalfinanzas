package upc.edu.pe.carterafinanzas.backend.api;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import upc.edu.pe.carterafinanzas.backend.Resource.Emisor.CreateEmisorResource;
import upc.edu.pe.carterafinanzas.backend.Resource.Emisor.EmisorResource;
import upc.edu.pe.carterafinanzas.backend.Resource.Emisor.UpdateEmisorResource;
import upc.edu.pe.carterafinanzas.backend.domain.service.EmisorService;
import upc.edu.pe.carterafinanzas.backend.mapping.EmisorMapper;


@RestController
@RequestMapping("/api/v1/emisores")
public class EmisorController {

    @Autowired
    private EmisorService emisorService;

    @Autowired
    private EmisorMapper mapper;

    @Autowired
    private ModelMapper mapping;


    @GetMapping
    public Page<EmisorResource> getAllForumComments(Pageable pageable) {
        return mapper.modelListToPage(emisorService.getAll(), pageable);
    }

    @GetMapping("{emisorId}")
    public EmisorResource getForumCommentById(@PathVariable("emisorId") Long emisorId) {
        return mapper.toResource(emisorService.getById(emisorId));
    }
    @PostMapping
    public EmisorResource createUser(@RequestBody CreateEmisorResource request) {

        return mapper.toResource(emisorService.create(mapper.toModel(request)));
    }
    @PutMapping("{emisorId}")
    public EmisorResource updateUser(@PathVariable Long emisorId, @RequestBody UpdateEmisorResource request) {
        return mapper.toResource(emisorService.update(emisorId, mapper.toModel(request)));
    }
    @DeleteMapping("{emisorId}")
    public ResponseEntity<?> deletePost(@PathVariable Long emisorId) {
        return emisorService.delete(emisorId);
    }















}
