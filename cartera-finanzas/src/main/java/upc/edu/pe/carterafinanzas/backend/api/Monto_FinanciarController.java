package upc.edu.pe.carterafinanzas.backend.api;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import upc.edu.pe.carterafinanzas.backend.Resource.Moneda.MonedaResource;
import upc.edu.pe.carterafinanzas.backend.Resource.Monto_Financiar.CreateMonto_FinanciarResource;
import upc.edu.pe.carterafinanzas.backend.Resource.Monto_Financiar.Monto_FinanciarResource;
import upc.edu.pe.carterafinanzas.backend.Resource.Monto_Financiar.UpdateMonto_FinanciarResource;

import upc.edu.pe.carterafinanzas.backend.domain.model.entity.Monto_Financiar;
import upc.edu.pe.carterafinanzas.backend.domain.service.Monto_FinanciarService;
import upc.edu.pe.carterafinanzas.backend.mapping.Monto_FinanciarMapper;


@RestController
@RequestMapping("/api/v1")
public class Monto_FinanciarController {




    @Autowired
    private Monto_FinanciarService monto_financiarService;

    @Autowired
    private Monto_FinanciarMapper mapper;

    @Autowired
    private ModelMapper mapping;


    @GetMapping("/montofinanciars")
    public Page<Monto_FinanciarResource> getAllForumComments(Pageable pageable) {
        return mapper.modelListToPage(monto_financiarService.getAll(), pageable);
    }

    @GetMapping("/montofinanciars/{Monto_FinanciarId}")
    public Monto_FinanciarResource getForumCommentById(@PathVariable("Monto_FinanciarId") Long Monto_FinanciarId) {
        return mapper.toResource(monto_financiarService.getById(Monto_FinanciarId));
    }
    @PutMapping("/montofinanciars/{Monto_FinanciarId}")
    public Monto_FinanciarResource updateForumComment(@PathVariable Long Monto_FinanciarId, @RequestBody UpdateMonto_FinanciarResource request) {
        return mapper.toResource(monto_financiarService.update(Monto_FinanciarId, mapper.toModel(request)));
    }

    @DeleteMapping("/montofinanciars/{Monto_FinanciarId}")
    public ResponseEntity<?> deleteForumComment(@PathVariable Long Monto_FinanciarId) {
        return monto_financiarService.delete(Monto_FinanciarId);
    }

    @PostMapping("/descuentos/{DescuentoId}/montofinanciars")
    public Monto_FinanciarResource createCartera(@PathVariable Long DescuentoId, @RequestBody CreateMonto_FinanciarResource request) {
        Monto_Financiar forumcomment = mapping.map(request, Monto_Financiar.class);
        return mapping.map(monto_financiarService.create(DescuentoId,  forumcomment), Monto_FinanciarResource.class);
    }

    @GetMapping("/descuentos/{DescuentoId}/montofinanciars")
    public Page<Monto_FinanciarResource> getAllForumCommentsByvalorId(@PathVariable Long DescuentoId, Pageable pageable) {
        return mapper.modelListToPage(monto_financiarService.findBydescuentoID(DescuentoId), pageable);
    }





















}
