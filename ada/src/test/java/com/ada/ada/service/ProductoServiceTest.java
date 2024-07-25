package com.ada.ada.service;

import com.ada.ada.entity.Producto;
import com.ada.ada.repository.ProductoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ProductoServiceTest {

    ProductoService productoService;
    ProductoRepository productoRepository;

    @BeforeEach
    void setUp(){
        productoRepository = mock(ProductoRepository.class);
        productoService = mock(ProductoService.class);
    }

    @Test
    void getProductos() {
        List<Producto> lista = new ArrayList<>();
        Producto producto = new Producto();
        producto.setStock("Stock");
        producto.setPrecio(1234);
        producto.setNombre("Nombre P");
        producto.setDescripcion("Descripcion");
        producto.setId(321L);
        lista.add(producto);
        when(productoService.getProductos()).thenReturn(lista);
        List<Producto> res = productoService.getProductos();
        assertEquals(lista, res);
    }

    @Test
    void save() {
    }

    @Test
    void getProductoId() {
        Producto producto = new Producto();
        producto.setStock("Stock");
        producto.setPrecio(1234);
        producto.setNombre("Nombre P");
        producto.setDescripcion("Descripcion");
        producto.setId(321L);
        when(productoService.getProductoId(anyLong())).thenReturn(Optional.of(producto));
        Optional<Producto> res = productoService.getProductoId(123L);
        Producto p = res.get();
        assertEquals(producto, p);
    }
}