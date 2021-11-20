package upc.edu.pe.carterafinanzas.backend.api;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import upc.edu.pe.carterafinanzas.backend.Resource.ResultadoComitente.CreateResultadoComitenteResource;
import upc.edu.pe.carterafinanzas.backend.Resource.ResultadoComitente.ResultadoComitenteResource;
import upc.edu.pe.carterafinanzas.backend.Resource.ResultadoComitente.UpdateResultadoComitenteResource;
import upc.edu.pe.carterafinanzas.backend.domain.service.ResultadoComitenteService;
import upc.edu.pe.carterafinanzas.backend.mapping.ResultadoComitenteMapper;


@RestController
@RequestMapping("/api/v1/resultadosdecomitentes")
public class ResultadoComitenteController {




    @Autowired
    private ResultadoComitenteService resultadoComitenteService;
    @Autowired
    private ResultadoComitenteMapper mapper;

    @Autowired
    private ModelMapper mapping;


    @GetMapping
    public Page<ResultadoComitenteResource> getAllForumComments(Pageable pageable) {
        return mapper.modelListToPage(resultadoComitenteService.getAll(), pageable);
    }

    @GetMapping("{resultadodecomitenteId}")
    public ResultadoComitenteResource getForumCommentById(@PathVariable("resultadodecomitenteId") Long resultadodecomitenteId) {
        return mapper.toResource(resultadoComitenteService.getById(resultadodecomitenteId));
    }
    @PostMapping
    public ResultadoComitenteResource createUser(@RequestBody CreateResultadoComitenteResource request) {

        return mapper.toResource(resultadoComitenteService.create(mapper.toModel(request)));
    }
    @PutMapping("{resultadodecomitenteId}")
    public ResultadoComitenteResource updateUser(@PathVariable Long resultadodecomitenteId, @RequestBody UpdateResultadoComitenteResource request) {
        return mapper.toResource(resultadoComitenteService.update(resultadodecomitenteId, mapper.toModel(request)));
    }
    @DeleteMapping("{resultadodecomitenteId}")
    public ResponseEntity<?> deletePost(@PathVariable Long resultadodecomitenteId) {
        return resultadoComitenteService.delete(resultadodecomitenteId);
    }

































}
