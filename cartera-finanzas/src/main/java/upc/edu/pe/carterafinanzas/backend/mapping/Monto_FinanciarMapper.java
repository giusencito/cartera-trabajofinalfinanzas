package upc.edu.pe.carterafinanzas.backend.mapping;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import java.util.List;


import upc.edu.pe.carterafinanzas.backend.Resource.Monto_Financiar.CreateMonto_FinanciarResource;
import upc.edu.pe.carterafinanzas.backend.Resource.Monto_Financiar.Monto_FinanciarResource;
import upc.edu.pe.carterafinanzas.backend.Resource.Monto_Financiar.UpdateMonto_FinanciarResource;
import upc.edu.pe.carterafinanzas.backend.domain.model.entity.Monto_Financiar;
import upc.edu.pe.carterafinanzas.shared.mapping.EnhancedModelMapper;
import java.io.Serializable;



public class Monto_FinanciarMapper implements Serializable{




    @Autowired
    EnhancedModelMapper mapper;

    public Monto_FinanciarResource toResource(Monto_Financiar model) {
        return mapper.map(model, Monto_FinanciarResource.class);
    }

    public Page<Monto_FinanciarResource> modelListToPage(List<Monto_Financiar> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, Monto_FinanciarResource.class), pageable, modelList.size());
    }

    public  Monto_Financiar toModel(CreateMonto_FinanciarResource resource) {
        return mapper.map(resource, Monto_Financiar.class);
    }

    public Monto_Financiar toModel(UpdateMonto_FinanciarResource resource) {
        return mapper.map(resource, Monto_Financiar.class);

    }






}
