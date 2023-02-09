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

import com.example.SoftManagement.Modelos.pedidoModel;
import com.example.SoftManagement.Servicios.pedidoService;

import com.example.SoftManagement.Modelos.productoModel;
import com.example.SoftManagement.Servicios.productoService;

// dev_JB - agregamos la etiqeuta @RestController para identificar que sea un Controlador del proyecto
// dev_JB - agregamos la etiqeuta @RequestMapping("") para identificar la ruta de los endpoint
@RestController
@RequestMapping("/pedido")
// @CrossOrigin(origins = "http://localhost:4200/")
public class pedidoController {

    // dev_JB - traemos los servicios con la etiqueta @Autowired
    @Autowired
    pedidoService pedidoService;

    @Autowired
    productoService productoService;

    // dev_JB - metodo para crear o actualizar un pedido
    @PostMapping()
    public pedidoModel crearPedido(@RequestBody pedidoModel pedido){
        
        Long id;
        id = pedido.getProducto_id();
        productoModel productoModel = this.productoService.detalleProducto(id).get();
        productoModel.setId(pedido.getProducto_id());
        productoModel.setStock(pedido.getCantidad() + productoModel.getStock());
        this.productoService.crearProducto(productoModel);

        return this.pedidoService.crearPedido(pedido);
    }

    @GetMapping()
    public ArrayList<pedidoModel> listarPedidos(){
        return this.pedidoService.listarPedidos();
    }

}
