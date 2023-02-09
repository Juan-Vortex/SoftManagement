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

import com.example.SoftManagement.Modelos.usuarioModel;
import com.example.SoftManagement.Servicios.usuarioService;

// dev_JB - agregamos la etiqeuta @RestController para identificar que sea un Controlador del proyecto
// dev_JB - agregamos la etiqeuta @RequestMapping("") para identificar la ruta de los endpoint
@RestController
@RequestMapping("/usuario")
// @CrossOrigin(origins = "http://localhost:4200/")
public class usuarioController {

    // dev_JB - traemos los servicios con la etiqueta @Autowired
    @Autowired
    usuarioService usuarioService;

    // dev_JB - ponemos la etiqueta @GetMapping() para ejecutar las funciones dependiedo la ruta que esten ejecutando

    // dev_JB - metodo listar productos
    @GetMapping()
    public ArrayList<usuarioModel> listarProductos(){
        return this.usuarioService.listarProductos();
    }

    // dev_JB - metodo ver detalle de un produto por el identificador
    @GetMapping(path = "/{id}")
    public Optional<usuarioModel> detalleProducto(@PathVariable("id") Long id){
        return this.usuarioService.detalleProducto(id);
    }

    // dev_JB - metodo para crear o actualizar un producto
    @PostMapping()
    public usuarioModel crearProducto(@RequestBody usuarioModel producto){
        return this.usuarioService.crearProducto(producto);
    }

    @DeleteMapping(path = "/{id}")
    public String eliminarProducto(@PathVariable("id") Long id){
        boolean ok = this.usuarioService.eliminarProducto(id);
        if (ok) {
            return "Usuario eliminado con exito";
        }else{
            return "Error al eliminar el Usuario";
        }
    }
    
}
