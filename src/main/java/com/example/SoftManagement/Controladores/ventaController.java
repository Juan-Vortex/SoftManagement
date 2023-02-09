package com.example.SoftManagement.Controladores;

import java.util.ArrayList;
import java.util.Optional;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SoftManagement.Modelos.ventaModel;
import com.example.SoftManagement.Servicios.ventaService;

import com.example.SoftManagement.Modelos.productoModel;
import com.example.SoftManagement.Servicios.productoService;

// dev_JB - agregamos la etiqeuta @RestController para identificar que sea un Controlador del proyecto
// dev_JB - agregamos la etiqeuta @RequestMapping("") para identificar la ruta de los endpoint
@RestController
@RequestMapping("/venta")
// @CrossOrigin(origins = "http://localhost:4200/")
public class ventaController {

    // dev_JB - traemos los servicios con la etiqueta @Autowired
    @Autowired
    ventaService ventaService;

    @Autowired
    productoService productoService;

    // dev_JB - metodo para crear o actualizar un venta
    @PostMapping()
    public ventaModel crearVenta(@RequestBody ventaModel venta){
        
        Long id;
        id = venta.getProducto_id();
        productoModel productoModel = this.productoService.detalleProducto(id).get();
        productoModel.setId(venta.getProducto_id());
        productoModel.setStock(productoModel.getStock() - venta.getCantidad());
        this.productoService.crearProducto(productoModel);

        return this.ventaService.crearVenta(venta);
    }

    @GetMapping()
    public List<ventaModel> listarVentas(){
        return this.ventaService.listarVentas();
    }

    @GetMapping(path = "/totalGanacia")
    public Optional<Long> totalGanacia(){
        return this.ventaService.totalGanacia();
    }


}
