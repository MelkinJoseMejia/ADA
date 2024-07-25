/**
 * Controller de la clase Productos
 */

package com.ada.ada.controller;

import com.ada.ada.entity.Producto;
import com.ada.ada.repository.ProductoRepository;
import com.ada.ada.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    ProductoService productoService;

    @Autowired
    ProductoRepository productoRepository;

    /**
     * Método que retorna todos los productos
     * @param
     * @return Listado de productos
     */
    @GetMapping("/listar")
    public ResponseEntity<List<Producto>> getProductos(){
        return new ResponseEntity<>(productoService.getProductos(), HttpStatus.OK);
    }

    /**
     * Método que permite crear un producto
     * @param producto Información del producto a crear
     * @return producto creado
     */
    @PostMapping("/crearProducto")
    public ResponseEntity<Producto> crearProducto(@RequestBody Producto producto){
        Producto _producto = productoService.save(producto);
        return new ResponseEntity<>(_producto, HttpStatus.CREATED);
    }

    /**
     * Método para buscar un producto por su Id
     * @param id del producto a buscar
     * @return Producto encontrado con el Id
     */
    @GetMapping("/{id}")
    public Optional<Producto> getProductoId(@PathVariable("id") Long id){
        return productoService.getProductoId(id);
    }

    /**
     * Método que permite editar la información del producto
     * @param id del producto a editar
     * @param producto Objeto con información para editar
     * @return Producto edtado
     */
    @PutMapping("/edit/{id}")
    public ResponseEntity<Producto> editarProducto(@PathVariable("id") Long id, @RequestBody Producto producto){
        Optional<Producto> prod = productoService.getProductoId(id);
        if(prod.isPresent()){
            Producto _producto = prod.get();
            _producto.setDescripcion(producto.getDescripcion());
            _producto.setNombre(producto.getNombre());
            _producto.setPrecio(producto.getPrecio());
            _producto.setStock(producto.getStock());
            return new ResponseEntity<>(productoService.save(_producto),HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Método para eliminar un Producto
     * @param id del producto a eliminar
     * @return Resultado de la acción
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> borrarProducto(@PathVariable("id") Long id){
        try{
            productoRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

}
