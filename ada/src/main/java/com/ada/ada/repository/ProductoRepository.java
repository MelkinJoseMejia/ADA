/**
 * Repository de la clase Productos
 */
package com.ada.ada.repository;

import com.ada.ada.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {

    List<Producto> findAll();

}
