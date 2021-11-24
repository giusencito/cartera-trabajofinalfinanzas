package upc.edu.pe.carterafinanzas.backend.mapping;

import upc.edu.pe.carterafinanzas.backend.Resource.ResultadoComitente.CreateResultadoComitenteResource;
import upc.edu.pe.carterafinanzas.backend.Resource.ResultadoComitente.ResultadoComitenteResource;
import upc.edu.pe.carterafinanzas.backend.Resource.ResultadoComitente.UpdateResultadoComitenteResource;
import upc.edu.pe.carterafinanzas.backend.domain.model.entity.ResultadoComitente;
import upc.edu.pe.carterafinanzas.shared.mapping.EnhancedModelMapper;
import java.io.Serializable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import java.util.List;
public class ResultadoComitenteMapper implements Serializable{


    @Autowired
    EnhancedModelMapper mapper;

    public ResultadoComitenteResource toResource(ResultadoComitente model) {
        return mapper.map(model, ResultadoComitenteResource.class);
    }

    public Page<ResultadoComitenteResource> modelListToPage(List<ResultadoComitente> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, ResultadoComitenteResource.class), pageable, modelList.size());
    }

    public  ResultadoComitente toModel(CreateResultadoComitenteResource resource) {
        return mapper.map(resource, ResultadoComitente.class);
    }

    public ResultadoComitente toModel(UpdateResultadoComitenteResource resource) {
        return mapper.map(resource, ResultadoComitente.class);

    }




}
