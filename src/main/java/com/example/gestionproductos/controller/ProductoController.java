package com.example.gestionproductos.controller;

import com.example.gestionproductos.model.Producto;
import com.example.gestionproductos.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    @Autowired
    private ProductoService service;

    @GetMapping
    public List<Producto> listar() {
        return service.listarTodos();
    }

    @PostMapping
    public Producto crear(@RequestBody Producto producto) {
        return service.guardar(producto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> obtener(@PathVariable Long id) {
        return service.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Producto> actualizar(@PathVariable Long id, @RequestBody Producto detallesProducto) {
        return service.obtenerPorId(id)
                .map(producto -> {
                    producto.setNombre(detallesProducto.getNombre());
                    producto.setDescripcion(detallesProducto.getDescripcion());
                    producto.setPrecio(detallesProducto.getPrecio());
                    producto.setCantidad(detallesProducto.getCantidad());
                    return ResponseEntity.ok(service.guardar(producto));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        return service.obtenerPorId(id)
                .map(producto -> {
                    service.eliminar(id);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
