package upc.edu.pe.carterafinanzas.backend.mapping;




import upc.edu.pe.carterafinanzas.backend.Resource.Movimiento.CreateMovimientoResource;
import upc.edu.pe.carterafinanzas.backend.Resource.Movimiento.MovimientoResource;
import upc.edu.pe.carterafinanzas.backend.Resource.Movimiento.UpdateMovimientoResource;
import upc.edu.pe.carterafinanzas.backend.domain.model.entity.Movimiento;
import upc.edu.pe.carterafinanzas.shared.mapping.EnhancedModelMapper;
import java.io.Serializable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import java.util.List;
public class MovimientoMapper implements Serializable{


    @Autowired
    EnhancedModelMapper mapper;

    public MovimientoResource toResource(Movimiento model) {
        return mapper.map(model, MovimientoResource.class);
    }

    public Page<MovimientoResource> modelListToPage(List<Movimiento> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, MovimientoResource.class), pageable, modelList.size());
    }

    public  Movimiento toModel(CreateMovimientoResource resource) {
        return mapper.map(resource, Movimiento.class);
    }

    public Movimiento toModel(UpdateMovimientoResource resource) {
        return mapper.map(resource, Movimiento.class);

    }







}
