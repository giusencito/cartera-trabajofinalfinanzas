package upc.edu.pe.carterafinanzas.backend.mapping;

import upc.edu.pe.carterafinanzas.backend.Resource.TipoMoneda.CreateTipoMonedaResource;
import upc.edu.pe.carterafinanzas.backend.Resource.TipoMoneda.TipoMonedaResource;
import upc.edu.pe.carterafinanzas.backend.Resource.TipoMoneda.UpdateTipoMonedaResource;
import upc.edu.pe.carterafinanzas.backend.domain.model.entity.TipoMoneda;
import upc.edu.pe.carterafinanzas.shared.mapping.EnhancedModelMapper;
import java.io.Serializable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import java.util.List;
public class TipoMonedaMapper implements Serializable{


    @Autowired
    EnhancedModelMapper mapper;

    public TipoMonedaResource toResource(TipoMoneda model) {
        return mapper.map(model, TipoMonedaResource.class);
    }

    public Page<TipoMonedaResource> modelListToPage(List<TipoMoneda> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, TipoMonedaResource.class), pageable, modelList.size());
    }

    public  TipoMoneda toModel(CreateTipoMonedaResource resource) {
        return mapper.map(resource, TipoMoneda.class);
    }

    public TipoMoneda toModel(UpdateTipoMonedaResource resource) {
        return mapper.map(resource, TipoMoneda.class);

    }
}
