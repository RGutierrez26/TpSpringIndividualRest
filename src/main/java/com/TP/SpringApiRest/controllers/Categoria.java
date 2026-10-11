package com.TP.SpringApiRest.controllers;

import com.TP.SpringApiRest.DTO.Categoria.CategoriaCreate;
import com.TP.SpringApiRest.DTO.Categoria.CategoriaDTO;
import com.TP.SpringApiRest.DTO.Categoria.CategoriaEDIT;
import com.TP.SpringApiRest.Service.Categoria.CategoriaServiceimpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categoria")
class Categoria {
    public final CategoriaServiceimpl categoriaServiceimpl;

    public Categoria(CategoriaServiceimpl categoriaServiceimpl) {
        this.categoriaServiceimpl = categoriaServiceimpl;
    }

    @RequestMapping
    public List<CategoriaDTO> listaCategorias() {
        return categoriaServiceimpl.findAll();
    }
    @RequestMapping("/{id}")
    public CategoriaDTO getCategoriaById(@RequestParam String id) {
        return categoriaServiceimpl.findById(id);
    }
    @PostMapping
    public CategoriaDTO createCategoria(@RequestBody CategoriaCreate categoriaDTO) {
        return categoriaServiceimpl.save(categoriaDTO);
    }

    @PutMapping("/{id}")
    public CategoriaDTO updateCategoria(@RequestParam String id, @RequestBody CategoriaEDIT categoriaDTO) {
        return categoriaServiceimpl.update(categoriaDTO, id);
    }

    @DeleteMapping("/{id}")
    public void deleteCategoria(@RequestParam String id) {
        categoriaServiceimpl.deleteById(id);
    }
}
