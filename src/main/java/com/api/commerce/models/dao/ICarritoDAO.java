package com.api.commerce.models.dao;

import com.api.commerce.models.entity.Carrito;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ICarritoDAO extends CrudRepository<Carrito, Long> {

    @Query("select c from Carrito c join fetch c.usuario u join fetch c.items i join fetch i.producto")
    List<Carrito> fetchByIdWithUIP();
}