package upc.edu.pe.carterafinanzas.backend.api;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import upc.edu.pe.carterafinanzas.backend.Resource.Usuario.CreateUsuarioResource;
import upc.edu.pe.carterafinanzas.backend.Resource.Usuario.UpdateUsuarioResource;
import upc.edu.pe.carterafinanzas.backend.Resource.Usuario.UsuarioResource;
import upc.edu.pe.carterafinanzas.backend.domain.service.UsuarioService;
import upc.edu.pe.carterafinanzas.backend.mapping.UsuarioMapper;


@RestController
@RequestMapping("/api/v1/usuarios")
public class UsuarioController {




    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private UsuarioMapper mapper;

    @Autowired
    private ModelMapper mapping;


    @GetMapping
    public Page<UsuarioResource> getAllForumComments(Pageable pageable) {
        return mapper.modelListToPage(usuarioService.getAll(), pageable);
    }

    @GetMapping("{usuarioId}")
    public UsuarioResource getForumCommentById(@PathVariable("usuarioId") Long usuarioId) {
        return mapper.toResource(usuarioService.getById(usuarioId));
    }
    @PostMapping
    public UsuarioResource createUser(@RequestBody CreateUsuarioResource request) {

        return mapper.toResource(usuarioService.create(mapper.toModel(request)));
    }
    @PutMapping("{usuarioId}")
    public UsuarioResource updateUser(@PathVariable Long usuarioId, @RequestBody UpdateUsuarioResource request) {
        return mapper.toResource(usuarioService.update(usuarioId, mapper.toModel(request)));
    }
    @DeleteMapping("{usuarioId}")
    public ResponseEntity<?> deletePost(@PathVariable Long emisorId) {
        return usuarioService.delete(emisorId);
    }
































}
