package com.example.SoftManagement.Modelos;

import jakarta.persistence.*;

// dev_JB - agregamos @Entity para que java sepa que es un modelo de BD o un POJO
// dev_JB - creamos un alis para que se cree con este nuestra entidad en la BD  ->  @Table(name = "producto")
// dev_JB - Abajo de este alias la clase modelo con sus setter y getter para los atributos de la entidad
@Entity
@Table(name = "producto")
public class productoModel {

    // dev_JB - agregamos las siguientes etiquetas de springboot -> @ para darle las propiedades a las entidades
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true,  nullable = false)
    private Long id;

    private String nombre;
    private String tipo;
    private Long stock;
    private Long stock_minimo;
    private Double valor_unitario;

    public productoModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Long getStock() {
        return stock;
    }

    public void setStock(Long stock) {
        this.stock = stock;
    }

    public Long getStock_minimo() {
        return stock_minimo;
    }

    public void setStock_minimo(Long stock_minimo) {
        this.stock_minimo = stock_minimo;
    }

    public Double getValor_unitario() {
        return valor_unitario;
    }

    public void setValor_unitario(Double valor_unitario) {
        this.valor_unitario = valor_unitario;
    }

}
