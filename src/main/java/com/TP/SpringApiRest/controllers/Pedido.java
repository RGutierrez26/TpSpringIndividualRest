package com.TP.SpringApiRest.controllers;

import com.TP.SpringApiRest.DTO.Pedido.PedidoCreate;
import com.TP.SpringApiRest.DTO.Pedido.PedidoDTO;
import com.TP.SpringApiRest.DTO.Pedido.PedidoEdit;
import com.TP.SpringApiRest.Service.Pedido.PedidoServiceimpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class Pedido {
    private final PedidoServiceimpl pedidoServiceimpl;
    public Pedido(PedidoServiceimpl pedidoServiceimpl) {
        this.pedidoServiceimpl = pedidoServiceimpl;
    }
    @RequestMapping
    public List<PedidoDTO> pedido() {
        return pedidoServiceimpl.findAll();
    }
    @RequestMapping("/{id}")
    public PedidoDTO getPedidoById(@RequestParam String id) {
        return pedidoServiceimpl.findById(id);
    }
    @PostMapping()
    public PedidoDTO createPedido(PedidoCreate pedidoDTO) {
        return pedidoServiceimpl.save(pedidoDTO);
    }
    @PutMapping("/{id}")
    public PedidoDTO updatePedido(@RequestParam String id, @RequestBody PedidoEdit pedidoDTO) {
        return pedidoServiceimpl.update(pedidoDTO, id);
    }

    @DeleteMapping("/{id}")
    public void deletePedido(@RequestParam String id) {
        pedidoServiceimpl.deleteById(id);
    }
}
