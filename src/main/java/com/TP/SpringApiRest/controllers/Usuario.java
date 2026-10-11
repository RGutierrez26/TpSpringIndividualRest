package com.TP.SpringApiRest.controllers;

import com.TP.SpringApiRest.DTO.Usuario.UsuarioCreate;
import com.TP.SpringApiRest.DTO.Usuario.UsuarioDTO;
import com.TP.SpringApiRest.DTO.Usuario.UsuarioEdit;
import com.TP.SpringApiRest.Service.Usuario.UsuarioServiceimpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
class Usuario {
    private final UsuarioServiceimpl usuarioServiceimpl;

    public Usuario(UsuarioServiceimpl usuarioServiceimpl) {
        this.usuarioServiceimpl = usuarioServiceimpl;
    }

    @RequestMapping
    public List<UsuarioDTO> getUsuarios() {
        return usuarioServiceimpl.findAll();
    }

    @RequestMapping("/{id}")
    public UsuarioDTO getUsuarioById(@PathVariable String id) {
        return usuarioServiceimpl.findById(id);
    }
    @PostMapping
    public UsuarioDTO createUsuario(@RequestBody UsuarioCreate usuarioCreate) {
        return usuarioServiceimpl.save(usuarioCreate);
    }
    @PutMapping("/{id}")
    public UsuarioDTO updateUsuario(@PathVariable  String id, @RequestBody UsuarioEdit usuarioEdit) {
        return usuarioServiceimpl.update(usuarioEdit, id);
    }

    @DeleteMapping("/{id}")
    public void deleteUsuario(@PathVariable  String id) {
        usuarioServiceimpl.deleteById(id);
    }

}
