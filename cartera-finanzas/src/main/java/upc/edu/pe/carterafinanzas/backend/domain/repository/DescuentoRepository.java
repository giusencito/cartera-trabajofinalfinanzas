package upc.edu.pe.carterafinanzas.backend.domain.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import upc.edu.pe.carterafinanzas.backend.domain.model.entity.*;

import java.util.List;

@Repository
public interface DescuentoRepository extends JpaRepository<Descuento,Integer> {
    @Query("from Descuento j where j.valorMN =: valorMN")
    public List<Descuento> buscarDescuentoMN(Double valorMN);

    @Query("from Descuento j where j.valorME =: valorMN")
    public List<Descuento> buscarDescuentoME(Double valorME);
}
