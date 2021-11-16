package upc.edu.pe.carterafinanzas.backend.domain.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import upc.edu.pe.carterafinanzas.backend.domain.model.entity.Descuento;
import upc.edu.pe.carterafinanzas.backend.domain.model.entity.Emisor;
import upc.edu.pe.carterafinanzas.backend.domain.model.entity.TipoMoneda;
import upc.edu.pe.carterafinanzas.backend.domain.model.entity.Valor;

import java.util.List;

public interface DescuentoRepository extends JpaRepository<Descuento,Long> {

    List<Descuento> findByemisorId(Long emisorId);
    List<Descuento> findByValorId(Long valorId);
    List<Descuento> findBytipodemonedaId(Long tipodemonedaId);





}
