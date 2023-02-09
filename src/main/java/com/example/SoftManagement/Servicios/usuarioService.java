package com.example.SoftManagement.Servicios;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SoftManagement.Modelos.usuarioModel;
import com.example.SoftManagement.Repositorios.usuarioRepository;

// dev_JB - ponemos la etqueta @Service para definir que es un servicio
@Service
public class usuarioService {

    // dev_JB - ponemos la etiqueta @Autowired para importar las intefaces que tenemos creadas
    @Autowired
    usuarioRepository usuarioRepository;

    // dev_JB - creamos el primer metodo listar todos los usuarios
    public ArrayList<usuarioModel> listarProductos(){
        return (ArrayList<usuarioModel>) usuarioRepository.findAll();
    }

    // dev_JB - creamos el segundo metodo ver detalle de un usuario
    public Optional<usuarioModel> detalleProducto(Long id){
        return usuarioRepository.findById(id);
    }

    // dev_JB - creamos el tercer metodo crear un usuario
    public usuarioModel crearProducto(usuarioModel usuario){
        return usuarioRepository.save(usuario);
    }

    // dev_JB - creamos el tercer metodo eliminar un usuario
    public boolean eliminarProducto(Long id){
        try {
            usuarioRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
