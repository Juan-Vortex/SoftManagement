package com.example.SoftManagement.Repositorios;

import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;//CrudRepository ORM 
import org.springframework.stereotype.Repository;

import com.example.SoftManagement.Modelos.productoModel;

@Repository
public interface productoRepository extends CrudRepository<productoModel, Long> {

    @Query(value = "SELECT producto.*, SUM(venta.cantidad) as cantidad FROM venta JOIN producto ON producto.id = venta.producto_id GROUP BY producto.id ORDER BY SUM(venta.cantidad) DESC LIMIT 1", nativeQuery = true)
    Optional<productoModel> productoMasVendido();

    @Query(value = "SELECT producto.*, SUM(venta.cantidad) as cantidad FROM venta JOIN producto ON producto.id = venta.producto_id GROUP BY producto.id ORDER BY SUM(venta.cantidad) ASC LIMIT 1", nativeQuery = true)
    Optional<productoModel> productoMenosVendido();

}
