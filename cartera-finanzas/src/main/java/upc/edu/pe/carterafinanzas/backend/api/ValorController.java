package upc.edu.pe.carterafinanzas.backend.api;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import upc.edu.pe.carterafinanzas.backend.Resource.Valor.CreateValorResource;
import upc.edu.pe.carterafinanzas.backend.Resource.Valor.UpdateValorResource;
import upc.edu.pe.carterafinanzas.backend.Resource.Valor.ValorResource;
import upc.edu.pe.carterafinanzas.backend.domain.service.ValorService;
import upc.edu.pe.carterafinanzas.backend.mapping.ValorMapper;


@RestController
@RequestMapping("/api/v1/valores")
public class ValorController {



    @Autowired
    private ValorService valorService;

    @Autowired
    private ValorMapper mapper;

    @Autowired
    private ModelMapper mapping;


    @GetMapping
    public Page<ValorResource> getAllForumComments(Pageable pageable) {
        return mapper.modelListToPage(valorService.getAll(), pageable);
    }

    @GetMapping("{valorId}")
    public ValorResource getForumCommentById(@PathVariable("valorId") Long valorId) {
        return mapper.toResource(valorService.getById(valorId));
    }
    @PostMapping
    public ValorResource createUser(@RequestBody CreateValorResource request) {

        return mapper.toResource(valorService.create(mapper.toModel(request)));
    }
    @PutMapping("{valorId}")
    public ValorResource updateUser(@PathVariable Long valorId, @RequestBody UpdateValorResource request) {
        return mapper.toResource(valorService.update(valorId, mapper.toModel(request)));
    }
    @DeleteMapping("{valorId}")
    public ResponseEntity<?> deletePost(@PathVariable Long emisorId) {
        return valorService.delete(emisorId);
    }




































}
