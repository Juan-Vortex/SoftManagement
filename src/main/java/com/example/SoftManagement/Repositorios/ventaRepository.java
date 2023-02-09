package com.example.SoftManagement.Repositorios;

import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;//CrudRepository ORM 
import org.springframework.stereotype.Repository;

import com.example.SoftManagement.Modelos.ventaModel;

@Repository
public interface ventaRepository extends CrudRepository<ventaModel, Long> {

    @Query(value = "SELECT SUM(venta.cantidad*producto.valor_unitario) as totalGanacia FROM venta JOIN producto ON producto.id = venta.producto_id", nativeQuery = true)
    Optional<Long> totalGanacia();

}
