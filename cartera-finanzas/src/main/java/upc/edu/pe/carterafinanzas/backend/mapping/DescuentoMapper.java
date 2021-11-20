package upc.edu.pe.carterafinanzas.backend.mapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import java.util.List;

import upc.edu.pe.carterafinanzas.backend.Resource.Descuento.CreateDescuentoResource;
import upc.edu.pe.carterafinanzas.backend.Resource.Descuento.DescuentoResource;
import upc.edu.pe.carterafinanzas.backend.Resource.Descuento.UpdateDescuentoResource;
import upc.edu.pe.carterafinanzas.backend.domain.model.entity.Descuento;
import upc.edu.pe.carterafinanzas.shared.mapping.EnhancedModelMapper;
import java.io.Serializable;



public class DescuentoMapper implements Serializable{



    @Autowired
    EnhancedModelMapper mapper;

    public DescuentoResource toResource(Descuento model) {
        return mapper.map(model, DescuentoResource.class);
    }

    public Page<DescuentoResource> modelListToPage(List<Descuento> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, DescuentoResource.class), pageable, modelList.size());
    }

    public  Descuento toModel(CreateDescuentoResource resource) {
        return mapper.map(resource, Descuento.class);
    }

    public Descuento toModel(UpdateDescuentoResource resource) {
        return mapper.map(resource, Descuento.class);

    }















}
