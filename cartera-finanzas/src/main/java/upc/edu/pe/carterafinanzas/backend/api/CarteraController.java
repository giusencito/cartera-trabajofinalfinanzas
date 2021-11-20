package upc.edu.pe.carterafinanzas.backend.api;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import upc.edu.pe.carterafinanzas.backend.Resource.Cartera.CarteraResource;
import upc.edu.pe.carterafinanzas.backend.Resource.Cartera.CreateCarteraResource;
import upc.edu.pe.carterafinanzas.backend.Resource.Cartera.UpdateCarteraResource;
import upc.edu.pe.carterafinanzas.backend.domain.model.entity.Cartera;
import upc.edu.pe.carterafinanzas.backend.domain.service.CarteraService;
import upc.edu.pe.carterafinanzas.backend.mapping.CarteraMapper;


@RestController
@RequestMapping("/api/v1")
public class CarteraController {


    @Autowired
    private CarteraService carteraService;

    @Autowired
    private CarteraMapper mapper;

    @Autowired
    private ModelMapper mapping;

    @GetMapping("/carteras")
    public Page<CarteraResource> getAllcarteras(Pageable pageable) {
        return mapper.modelListToPage(carteraService.getAll(), pageable);
    }

    @GetMapping("/carteras/{carteraId}")
    public CarteraResource getForumCommentById(@PathVariable("carteraId") Long carteraId) {
        return mapper.toResource(carteraService.getById(carteraId));
    }

    @PostMapping("/usuarios/{usuarioId}/carteras")
    public CarteraResource createCartera(@PathVariable Long usuarioId, @RequestBody CreateCarteraResource request) {
        Cartera forumcomment = mapping.map(request, Cartera.class);
        return mapping.map(carteraService.create(usuarioId,  forumcomment), CarteraResource.class);
    }

    @PutMapping("/carteras/{carteraId}")
    public CarteraResource updateForumComment(@PathVariable Long carteraId, @RequestBody UpdateCarteraResource request) {
        return mapper.toResource(carteraService.update(carteraId, mapper.toModel(request)));
    }

    @DeleteMapping("/carteras/{carteraId}")
    public ResponseEntity<?> deleteForumComment(@PathVariable Long carteraId) {
        return carteraService.delete(carteraId);
    }

    @GetMapping("/usuarios/{usuarioId}/carteras")
    public Page<CarteraResource> getAllForumCommentsByForumId(@PathVariable Long usuarioId,Pageable pageable) {
        return mapper.modelListToPage(carteraService.findByUsuarioId(usuarioId), pageable);
    }


































}
