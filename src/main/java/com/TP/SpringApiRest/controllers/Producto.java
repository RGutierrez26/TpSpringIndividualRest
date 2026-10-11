package com.TP.SpringApiRest.controllers;

import com.TP.SpringApiRest.DTO.Producto.ProductoCreate;
import com.TP.SpringApiRest.DTO.Producto.ProductoDTO;
import com.TP.SpringApiRest.DTO.Producto.ProductoEdit;
import com.TP.SpringApiRest.Service.Producto.ProductoService;
import com.TP.SpringApiRest.Service.Producto.ProductoServiceimpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
class Producto {
    private final ProductoServiceimpl productoService;

    public Producto(ProductoServiceimpl productoService) {
        this.productoService = productoService;
    }


    @RequestMapping
    public List<ProductoDTO> getProductos() {
        return productoService.findAll();
    }
    @RequestMapping("/{id}")
    public ProductoDTO getProductoById(@PathVariable String id) {
        return productoService.findById(id);
    }
    @PutMapping("/{id}")
    public ProductoDTO updateProducto(@PathVariable String id, @RequestBody ProductoEdit productoDTO) {
        return productoService.update(productoDTO,id);
    }
    @PostMapping
    public ProductoDTO createProducto(@RequestBody ProductoCreate productoDTO) {
        return productoService.save(productoDTO);
    }
    @DeleteMapping("/{id}")
    public void deleteProducto(@PathVariable String id) {
        productoService.deleteById(id);
    }


}
