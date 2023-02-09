package com.example.SoftManagement.Modelos;

import jakarta.persistence.*;

// dev_JB - agregamos @Entity para que java sepa que es un modelo de BD o un POJO
// dev_JB - creamos un alis para que se cree con este nuestra entidad en la BD  ->  @Table(name = "usuario")
// dev_JB - Abajo de este alias la clase modelo con sus setter y getter para los atributos de la entidad
@Entity
@Table(name = "venta")
public class ventaModel {

    // dev_JB - agregamos las siguientes etiquetas de springboot -> @ para darle las propiedades a las entidades
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true,  nullable = false)
    private Long id;

    private Long cantidad;
    private Long producto_id;
    private Long cliente_id;

    public ventaModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCantidad() {
        return cantidad;
    }

    public void setCantidad(Long cantidad) {
        this.cantidad = cantidad;
    }

    public Long getProducto_id() {
        return producto_id;
    }

    public void setProducto_id(Long producto_id) {
        this.producto_id = producto_id;
    }

    public Long getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(Long cliente_id) {
        this.cliente_id = cliente_id;
    }
    
}
