package upc.edu.pe.carterafinanzas.backend.mapping;

import upc.edu.pe.carterafinanzas.backend.Resource.ResultadoMovimiento.CreateResultadoMovimientoResource;
import upc.edu.pe.carterafinanzas.backend.Resource.ResultadoMovimiento.ResultadoMovimientoResource;
import upc.edu.pe.carterafinanzas.backend.Resource.ResultadoMovimiento.UpdateResultadoMovimientoResource;
import upc.edu.pe.carterafinanzas.backend.domain.model.entity.ResultadoMovimiento;
import upc.edu.pe.carterafinanzas.shared.mapping.EnhancedModelMapper;
import java.io.Serializable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import java.util.List;
public class ResultadoMovimientoMapper implements Serializable{


    @Autowired
    EnhancedModelMapper mapper;

    public ResultadoMovimientoResource toResource(ResultadoMovimiento model) {
        return mapper.map(model, ResultadoMovimientoResource.class);
    }

    public Page<ResultadoMovimientoResource> modelListToPage(List<ResultadoMovimiento> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, ResultadoMovimientoResource.class), pageable, modelList.size());
    }

    public  ResultadoMovimiento toModel(CreateResultadoMovimientoResource resource) {
        return mapper.map(resource, ResultadoMovimiento.class);
    }

    public ResultadoMovimiento toModel(UpdateResultadoMovimientoResource resource) {
        return mapper.map(resource, ResultadoMovimiento.class);

    }


}
