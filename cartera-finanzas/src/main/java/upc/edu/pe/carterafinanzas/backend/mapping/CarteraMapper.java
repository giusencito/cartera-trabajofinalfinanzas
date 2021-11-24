package upc.edu.pe.carterafinanzas.backend.mapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import java.util.List;


import upc.edu.pe.carterafinanzas.shared.mapping.EnhancedModelMapper;
import java.io.Serializable;

import upc.edu.pe.carterafinanzas.backend.Resource.Cartera.CreateCarteraResource;
import upc.edu.pe.carterafinanzas.backend.Resource.Cartera.UpdateCarteraResource;
import upc.edu.pe.carterafinanzas.backend.Resource.Cartera.CarteraResource;
import upc.edu.pe.carterafinanzas.backend.domain.model.entity.Cartera;
public class CarteraMapper implements Serializable {

    @Autowired
    EnhancedModelMapper mapper;

    public CarteraResource toResource(Cartera model) {
        return mapper.map(model, CarteraResource.class);
    }

    public Page<CarteraResource> modelListToPage(List<Cartera> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, CarteraResource.class), pageable, modelList.size());
    }

    public  Cartera toModel(CreateCarteraResource resource) {
        return mapper.map(resource, Cartera.class);
    }

    public Cartera toModel(UpdateCarteraResource resource) {
        return mapper.map(resource, Cartera.class);
    }




}
