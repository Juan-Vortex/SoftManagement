package com.example.SoftManagement.Controladores;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SoftManagement.Modelos.productoModel;
import com.example.SoftManagement.Servicios.productoService;

// dev_JB - agregamos la etiqeuta @RestController para identificar que sea un Controlador del proyecto
// dev_JB - agregamos la etiqeuta @RequestMapping("") para identificar la ruta de los endpoint
@RestController
@RequestMapping("/producto")
// @CrossOrigin(origins = "http://localhost:4200/")
public class productoController {

    // dev_JB - traemos los servicios con la etiqueta @Autowired
    @Autowired
    productoService serviciosProducto;

    // dev_JB - ponemos la etiqueta @GetMapping() para ejecutar las funciones dependiedo la ruta que esten ejecutando

    // dev_JB - metodo listar productos
    @GetMapping()
    public ArrayList<productoModel> listarProductos(){
        return this.serviciosProducto.listarProductos();
    }

    // dev_JB - metodo ver detalle de un produto por el identificador
    @GetMapping(path = "/{id}")
    public Optional<productoModel> detalleProducto(@PathVariable("id") Long id){
        return this.serviciosProducto.detalleProducto(id);
    }

    // dev_JB - metodo para crear o actualizar un producto
    @PostMapping()
    public productoModel crearProducto(@RequestBody productoModel producto){
        return this.serviciosProducto.crearProducto(producto);
    }

    @DeleteMapping(path = "/{id}")
    public String eliminarProducto(@PathVariable("id") Long id){
        boolean ok = this.serviciosProducto.eliminarProducto(id);
        if (ok) {
            return "Producto eliminado con exito";
        }else{
            return "Error al eliminar el Producto";
        }
    }

    @GetMapping(path = "/productoMasVendido")
    public Optional<productoModel> productoMasVendido(){
        return this.serviciosProducto.productoMasVendido();
    }

    @GetMapping(path = "/productoMenosVendido")
    public Optional<productoModel> productoMenosVendido(){
        return this.serviciosProducto.productoMenosVendido();
    }
    
}
