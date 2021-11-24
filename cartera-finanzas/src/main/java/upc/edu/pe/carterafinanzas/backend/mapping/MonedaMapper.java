package upc.edu.pe.carterafinanzas.backend.mapping;

import upc.edu.pe.carterafinanzas.backend.Resource.Moneda.CreateMonedaResource;
import upc.edu.pe.carterafinanzas.backend.Resource.Moneda.MonedaResource;
import upc.edu.pe.carterafinanzas.backend.Resource.Moneda.UpdateMonedaResource;
import upc.edu.pe.carterafinanzas.backend.domain.model.entity.Moneda;
import upc.edu.pe.carterafinanzas.shared.mapping.EnhancedModelMapper;
import java.io.Serializable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import java.util.List;
public class MonedaMapper implements Serializable{



    @Autowired
    EnhancedModelMapper mapper;

    public MonedaResource toResource(Moneda model) {
        return mapper.map(model, MonedaResource.class);
    }

    public Page<MonedaResource> modelListToPage(List<Moneda> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, MonedaResource.class), pageable, modelList.size());
    }

    public  Moneda toModel(CreateMonedaResource resource) {
        return mapper.map(resource, Moneda.class);
    }

    public Moneda toModel(UpdateMonedaResource resource) {
        return mapper.map(resource, Moneda.class);

    }





}
