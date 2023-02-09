package com.example.SoftManagement.Servicios;

import java.util.ArrayList;
import java.util.Optional;
import java.util.List;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SoftManagement.Modelos.ventaModel;
import com.example.SoftManagement.Repositorios.ventaRepository;

// dev_JB - ponemos la etqueta @Service para definir que es un servicio
@Service
public class ventaService {

    // dev_JB - ponemos la etiqueta @Autowired para importar las intefaces que tenemos creadas
    @Autowired
    ventaRepository ventaRepository;

    // dev_JB - metodo crear un pedido
    public ventaModel crearVenta(ventaModel pedido){
        return ventaRepository.save(pedido);
    }

    public ArrayList<ventaModel> listarVentas(){
        return (ArrayList<ventaModel>) ventaRepository.findAll();
    }

    public Optional<Long> totalGanacia(){
        return ventaRepository.totalGanacia();
    }

}
