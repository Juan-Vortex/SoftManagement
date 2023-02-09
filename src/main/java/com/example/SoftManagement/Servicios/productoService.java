package com.example.SoftManagement.Servicios;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SoftManagement.Modelos.productoModel;
import com.example.SoftManagement.Repositorios.productoRepository;

// dev_JB - ponemos la etqueta @Service para definir que es un servicio
@Service
public class productoService {

    // dev_JB - ponemos la etiqueta @Autowired para importar las intefaces que tenemos creadas
    @Autowired
    productoRepository productoRepository;

    // dev_JB - creamos el primer metodo listar todos los productos
    public ArrayList<productoModel> listarProductos(){
        return (ArrayList<productoModel>) productoRepository.findAll();
    }

    public Optional<productoModel> productoMasVendido(){
        return productoRepository.productoMasVendido();
    }

    public Optional<productoModel> productoMenosVendido(){
        return productoRepository.productoMenosVendido();
    }

    // dev_JB - creamos el segundo metodo ver detalle de un producto
    public Optional<productoModel> detalleProducto(Long id){
        return productoRepository.findById(id);
    }

    // dev_JB - creamos el tercer metodo crear un producto
    public productoModel crearProducto(productoModel producto){
        return productoRepository.save(producto);
    }

    // dev_JB - creamos el tercer metodo eliminar un producto
    public boolean eliminarProducto(Long id){
        try {
            productoRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
