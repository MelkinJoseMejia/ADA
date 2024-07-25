/**
 * Service de la clase Productos
 */
package com.ada.ada.service;

import com.ada.ada.entity.Producto;
import com.ada.ada.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    @Autowired
    ProductoRepository productoRepository;

    public List<Producto> getProductos(){
        List<Producto> lista = new ArrayList<>();
        lista = productoRepository.findAll();
        return lista;
    }

    public Producto save(Producto producto){
        return productoRepository.save(producto);
    }

    public Optional<Producto> getProductoId(Long id){
        return productoRepository.findById(id);
    }

}
