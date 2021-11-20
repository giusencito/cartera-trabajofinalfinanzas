package upc.edu.pe.carterafinanzas.backend.api;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import upc.edu.pe.carterafinanzas.backend.Resource.Cartera.CarteraResource;
import upc.edu.pe.carterafinanzas.backend.Resource.Cartera.CreateCarteraResource;
import upc.edu.pe.carterafinanzas.backend.Resource.Moneda.MonedaResource;
import upc.edu.pe.carterafinanzas.backend.Resource.Movimiento.CreateMovimientoResource;
import upc.edu.pe.carterafinanzas.backend.Resource.Movimiento.MovimientoResource;
import upc.edu.pe.carterafinanzas.backend.Resource.Movimiento.UpdateMovimientoResource;
import upc.edu.pe.carterafinanzas.backend.domain.model.entity.Cartera;
import upc.edu.pe.carterafinanzas.backend.domain.model.entity.Movimiento;
import upc.edu.pe.carterafinanzas.backend.domain.repository.MovimientoRepository;
import upc.edu.pe.carterafinanzas.backend.domain.service.MovimientoService;
import upc.edu.pe.carterafinanzas.backend.mapping.MovimientoMapper;


@RestController
@RequestMapping("/api/v1")
public class MovimientoController {


    @Autowired
    private MovimientoService movimientoService;

    @Autowired
    private MovimientoMapper mapper;

    @Autowired
    private ModelMapper mapping;



    @GetMapping("/movimientos")
    public Page<MovimientoResource> getAllForumComments(Pageable pageable) {
        return mapper.modelListToPage(movimientoService.getAll(), pageable);
    }

    @GetMapping("/movimientos/{movmientoId}")
    public MovimientoResource getForumCommentById(@PathVariable("movmientoId") Long movmientoId) {
        return mapper.toResource(movimientoService.getById(movmientoId));
    }
    @PutMapping("/movimientos/{movmientoId}")
    public MovimientoResource updateForumComment(@PathVariable Long movmientoId, @RequestBody UpdateMovimientoResource request) {
        return mapper.toResource(movimientoService.update(movmientoId, mapper.toModel(request)));
    }

    @DeleteMapping("/movimientos/{movmientoId}")
    public ResponseEntity<?> deleteForumComment(@PathVariable Long movmientoId) {
        return movimientoService.delete(movmientoId);
    }

    @PostMapping("/tiposdemonedas/{tipodemonedaId}/resultadoMovimientos/{ResultadoMovimientoId}/movimientos")
    public MovimientoResource createCartera(@PathVariable Long tipodemonedaId,@PathVariable Long ResultadoMovimientoId ,@RequestBody CreateMovimientoResource request) {
        Movimiento forumcomment = mapping.map(request, Movimiento.class);
        return mapping.map(movimientoService.create(tipodemonedaId,ResultadoMovimientoId ,forumcomment), MovimientoResource.class);
    }

    @GetMapping("/tipodemonedas/{tipodemonedaId}/movimientos")
    public Page<MovimientoResource> getAllForumCommentsBytipomonedaId(@PathVariable Long tipodemonedaId, Pageable pageable) {
        return mapper.modelListToPage(movimientoService.findBytipodemonedaId(tipodemonedaId), pageable);
    }

    @GetMapping("/resultadoMovimientos/{ResultadoMovimientoId}/movimientos")
    public Page<MovimientoResource> getAllForumCommentsBycarteraId(@PathVariable Long ResultadoMovimientoId,Pageable pageable) {
        return mapper.modelListToPage(movimientoService.findByResultadoMovimientoId(ResultadoMovimientoId), pageable);
    }






















}

