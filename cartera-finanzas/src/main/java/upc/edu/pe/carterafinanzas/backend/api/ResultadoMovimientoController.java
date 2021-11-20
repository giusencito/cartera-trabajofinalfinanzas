package upc.edu.pe.carterafinanzas.backend.api;



import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import upc.edu.pe.carterafinanzas.backend.Resource.ResultadoMovimiento.CreateResultadoMovimientoResource;
import upc.edu.pe.carterafinanzas.backend.Resource.ResultadoMovimiento.ResultadoMovimientoResource;
import upc.edu.pe.carterafinanzas.backend.Resource.ResultadoMovimiento.UpdateResultadoMovimientoResource;
import upc.edu.pe.carterafinanzas.backend.domain.service.ResultadoMovimientoService;
import upc.edu.pe.carterafinanzas.backend.mapping.ResultadoMovimientoMapper;


@RestController
@RequestMapping("/api/v1/resultadosdemovimientos")
public class ResultadoMovimientoController {


    @Autowired
    private ResultadoMovimientoService resultadoMovimientoService;
    @Autowired
    private ResultadoMovimientoMapper mapper;

    @Autowired
    private ModelMapper mapping;


    @GetMapping
    public Page<ResultadoMovimientoResource> getAllForumComments(Pageable pageable) {
        return mapper.modelListToPage(resultadoMovimientoService.getAll(), pageable);
    }

    @GetMapping("{resultadodemovimientoId}")
    public ResultadoMovimientoResource getForumCommentById(@PathVariable("resultadodemovimientoId") Long resultadodemovimientoId) {
        return mapper.toResource(resultadoMovimientoService.getById(resultadodemovimientoId));
    }
    @PostMapping
    public ResultadoMovimientoResource createUser(@RequestBody CreateResultadoMovimientoResource request) {

        return mapper.toResource(resultadoMovimientoService.create(mapper.toModel(request)));
    }
    @PutMapping("{resultadodemovimientoId}")
    public ResultadoMovimientoResource updateUser(@PathVariable Long resultadodemovimientoId, @RequestBody UpdateResultadoMovimientoResource request) {
        return mapper.toResource(resultadoMovimientoService.update(resultadodemovimientoId, mapper.toModel(request)));
    }
    @DeleteMapping("{resultadodemovimientoId}")
    public ResponseEntity<?> deletePost(@PathVariable Long resultadodemovimientoId) {
        return resultadoMovimientoService.delete(resultadodemovimientoId);
    }












































}
