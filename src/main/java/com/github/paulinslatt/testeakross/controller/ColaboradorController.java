package com.github.paulinslatt.testeakross.controller;

import com.github.paulinslatt.testeakross.dto.ColaboradorDTO;
import com.github.paulinslatt.testeakross.service.ColaboradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/colaboradores")
public class ColaboradorController {

    @Autowired
    private ColaboradorService service;

    @PostMapping
    public ResponseEntity<ColaboradorDTO> salvar(@RequestBody ColaboradorDTO dto) {
        ColaboradorDTO colaborador = service.salvar(dto);
        URI uri = UriComponentsBuilder.fromPath("/colaboradores/{id}").buildAndExpand(colaborador.id()).toUri();
        return ResponseEntity.created(uri).body(colaborador);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ColaboradorDTO> consultarPorId(@PathVariable Long id) {
        ColaboradorDTO colaborador = service.consultarPorId(id);
        if (colaborador != null) {
            return ResponseEntity.ok(colaborador);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<ColaboradorDTO>> listarTodos() {
        List<ColaboradorDTO> colaboradores = service.listarTodos();
        return ResponseEntity.ok(colaboradores);
    }

}
