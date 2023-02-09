package com.example.SoftManagement.Repositorios;

import org.springframework.data.repository.CrudRepository;//CrudRepository ORM 
import org.springframework.stereotype.Repository;

import com.example.SoftManagement.Modelos.pedidoModel;

@Repository
public interface pedidoRepository extends CrudRepository<pedidoModel, Long> {

}
