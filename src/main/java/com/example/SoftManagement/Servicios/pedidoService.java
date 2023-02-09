package com.example.SoftManagement.Servicios;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SoftManagement.Modelos.pedidoModel;
import com.example.SoftManagement.Repositorios.pedidoRepository;

// dev_JB - ponemos la etqueta @Service para definir que es un servicio
@Service
public class pedidoService {

    // dev_JB - ponemos la etiqueta @Autowired para importar las intefaces que tenemos creadas
    @Autowired
    pedidoRepository pedidoRepository;

    // dev_JB - metodo crear un pedido
    public pedidoModel crearPedido(pedidoModel pedido){
        return pedidoRepository.save(pedido);
    }

    public ArrayList<pedidoModel> listarPedidos(){
        return (ArrayList<pedidoModel>) pedidoRepository.findAll();
    }

}
