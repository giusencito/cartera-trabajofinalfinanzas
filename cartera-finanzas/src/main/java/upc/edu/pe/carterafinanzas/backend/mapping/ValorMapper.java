package upc.edu.pe.carterafinanzas.backend.mapping;
import java.io.Serializable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import upc.edu.pe.carterafinanzas.backend.Resource.Valor.CreateValorResource;
import upc.edu.pe.carterafinanzas.backend.Resource.Valor.UpdateValorResource;
import upc.edu.pe.carterafinanzas.backend.Resource.Valor.ValorResource;
import upc.edu.pe.carterafinanzas.backend.domain.model.entity.Valor;
import upc.edu.pe.carterafinanzas.shared.mapping.EnhancedModelMapper;

import java.util.List;
public class ValorMapper implements Serializable{

    @Autowired
    EnhancedModelMapper mapper;

    public ValorResource toResource(Valor model) {
        return mapper.map(model, ValorResource.class);
    }

    public Page<ValorResource> modelListToPage(List<Valor> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, ValorResource.class), pageable, modelList.size());
    }

    public  Valor toModel(CreateValorResource resource) {
        return mapper.map(resource, Valor.class);
    }

    public Valor toModel(UpdateValorResource resource) {
        return mapper.map(resource, Valor.class);

    }








}
