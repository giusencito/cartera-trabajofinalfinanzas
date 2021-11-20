package upc.edu.pe.carterafinanzas.backend.domain.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import upc.edu.pe.carterafinanzas.backend.domain.model.entity.Monto_Financiar;

import java.util.List;

public interface Monto_FinanciarService {

    List<Monto_Financiar> getAll();
    Page<Monto_Financiar> getAll(Pageable pageable);
    Monto_Financiar getById(Long Monto_FinanciarId);
    Monto_Financiar create(Long DescuentoId,Monto_Financiar moneda);
    Monto_Financiar update(Long Monto_FinanciarId,Monto_Financiar request);
    ResponseEntity<?> delete(Long Monto_FinanciarId);
    List<Monto_Financiar> findBydescuentoID(Long DescuentoId);




}
