package com.example.SoftManagement.Repositorios;

import org.springframework.data.repository.CrudRepository;//CrudRepository ORM 
import org.springframework.stereotype.Repository;

import com.example.SoftManagement.Modelos.usuarioModel;

@Repository
public interface usuarioRepository extends CrudRepository<usuarioModel, Long> {

}
