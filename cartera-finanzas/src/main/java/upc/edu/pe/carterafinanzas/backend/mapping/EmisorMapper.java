package upc.edu.pe.carterafinanzas.backend.mapping;


import upc.edu.pe.carterafinanzas.backend.Resource.Emisor.CreateEmisorResource;
import upc.edu.pe.carterafinanzas.backend.Resource.Emisor.EmisorResource;
import upc.edu.pe.carterafinanzas.backend.Resource.Emisor.UpdateEmisorResource;
import upc.edu.pe.carterafinanzas.backend.domain.model.entity.Emisor;
import upc.edu.pe.carterafinanzas.shared.mapping.EnhancedModelMapper;
import java.io.Serializable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import java.util.List;





public class EmisorMapper implements Serializable{


    @Autowired
    EnhancedModelMapper mapper;

    public EmisorResource toResource(Emisor model) {
        return mapper.map(model, EmisorResource.class);
    }

    public Page<EmisorResource> modelListToPage(List<Emisor> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, EmisorResource.class), pageable, modelList.size());
    }

    public  Emisor toModel(CreateEmisorResource resource) {
        return mapper.map(resource, Emisor.class);
    }

    public Emisor toModel(UpdateEmisorResource resource) {
        return mapper.map(resource, Emisor.class);

    }








}
