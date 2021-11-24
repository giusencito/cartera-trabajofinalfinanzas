package upc.edu.pe.carterafinanzas.backend.mapping;


import java.io.Serializable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import upc.edu.pe.carterafinanzas.backend.Resource.Usuario.CreateUsuarioResource;
import upc.edu.pe.carterafinanzas.backend.Resource.Usuario.UpdateUsuarioResource;
import upc.edu.pe.carterafinanzas.backend.Resource.Usuario.UsuarioResource;
import upc.edu.pe.carterafinanzas.backend.domain.model.entity.Usuario;
import upc.edu.pe.carterafinanzas.shared.mapping.EnhancedModelMapper;

import java.util.List;

public class UsuarioMapper implements Serializable{


    @Autowired
    EnhancedModelMapper mapper;

    public UsuarioResource toResource(Usuario model) {
        return mapper.map(model, UsuarioResource.class);
    }

    public Page<UsuarioResource> modelListToPage(List<Usuario> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, UsuarioResource.class), pageable, modelList.size());
    }

    public  Usuario toModel(CreateUsuarioResource resource) {
        return mapper.map(resource, Usuario.class);
    }

    public Usuario toModel(UpdateUsuarioResource resource) {
        return mapper.map(resource, Usuario.class);

    }
















}
