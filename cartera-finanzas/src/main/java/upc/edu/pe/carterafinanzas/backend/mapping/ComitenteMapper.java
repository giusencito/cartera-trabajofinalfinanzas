package upc.edu.pe.carterafinanzas.backend.mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import java.util.List;
import upc.edu.pe.carterafinanzas.shared.mapping.EnhancedModelMapper;
import java.io.Serializable;






import upc.edu.pe.carterafinanzas.backend.Resource.Comitente.ComitenteResource;
import upc.edu.pe.carterafinanzas.backend.Resource.Comitente.CreateComitenteResource;
import upc.edu.pe.carterafinanzas.backend.Resource.Comitente.UpdateComitenteResource;
import upc.edu.pe.carterafinanzas.backend.domain.model.entity.Comitente;

public class ComitenteMapper implements Serializable{


    @Autowired
    EnhancedModelMapper mapper;

    public ComitenteResource toResource(Comitente model) {
        return mapper.map(model, ComitenteResource.class);
    }

    public Page<ComitenteResource> modelListToPage(List<Comitente> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, ComitenteResource.class), pageable, modelList.size());
    }

    public  Comitente toModel(CreateComitenteResource resource) {
        return mapper.map(resource, Comitente.class);
    }

    public Comitente toModel(UpdateComitenteResource resource) {
        return mapper.map(resource, Comitente.class);

    }









}
