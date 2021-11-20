package upc.edu.pe.carterafinanzas.backend.api;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import upc.edu.pe.carterafinanzas.backend.Resource.TipoMoneda.CreateTipoMonedaResource;
import upc.edu.pe.carterafinanzas.backend.Resource.TipoMoneda.TipoMonedaResource;
import upc.edu.pe.carterafinanzas.backend.Resource.TipoMoneda.UpdateTipoMonedaResource;
import upc.edu.pe.carterafinanzas.backend.domain.service.TipoMonedaService;
import upc.edu.pe.carterafinanzas.backend.mapping.TipoMonedaMapper;


@RestController
@RequestMapping("/api/v1/tipodemonedas")
public class TipoMonedaController {



    @Autowired
    private TipoMonedaService tipoMonedaService;
    @Autowired
    private TipoMonedaMapper mapper;

    @Autowired
    private ModelMapper mapping;


    @GetMapping
    public Page<TipoMonedaResource> getAllForumComments(Pageable pageable) {
        return mapper.modelListToPage(tipoMonedaService.getAll(), pageable);
    }

    @GetMapping("{tipodemonedaId}")
    public TipoMonedaResource getForumCommentById(@PathVariable("tipodemonedaId") Long tipodemonedaId) {
        return mapper.toResource(tipoMonedaService.getById(tipodemonedaId));
    }
    @PostMapping
    public TipoMonedaResource createUser(@RequestBody CreateTipoMonedaResource request) {

        return mapper.toResource(tipoMonedaService.create(mapper.toModel(request)));
    }
    @PutMapping("{tipodemonedaId}")
    public TipoMonedaResource updateUser(@PathVariable Long tipodemonedaId, @RequestBody UpdateTipoMonedaResource request) {
        return mapper.toResource(tipoMonedaService.update(tipodemonedaId, mapper.toModel(request)));
    }
    @DeleteMapping("{tipodemonedaId}")
    public ResponseEntity<?> deletePost(@PathVariable Long tipodemonedaId) {
        return tipoMonedaService.delete(tipodemonedaId);
    }







































}
