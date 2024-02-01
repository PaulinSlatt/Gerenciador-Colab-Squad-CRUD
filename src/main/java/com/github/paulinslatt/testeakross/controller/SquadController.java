package com.github.paulinslatt.testeakross.controller;

import com.github.paulinslatt.testeakross.dto.SquadDTO;
import com.github.paulinslatt.testeakross.service.SquadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/squads")
public class SquadController {

    @Autowired
    private SquadService service;

    @PostMapping
    public ResponseEntity<SquadDTO> salvar(@RequestBody SquadDTO dto) {
        SquadDTO squad = service.salvar(dto);
        URI uri = UriComponentsBuilder.fromPath("/squads/{id}").buildAndExpand(squad.id()).toUri();
        return ResponseEntity.created(uri).body(squad);
    }

    @PutMapping("/{idSquad}")
    public ResponseEntity<SquadDTO> adicionarColaborador(@PathVariable Long idSquad, @RequestParam Long idColaborador) {
        SquadDTO squad = service.adicionarColaborador(idColaborador, idSquad);
        return ResponseEntity.ok(squad);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SquadDTO> consultarPorId(@PathVariable Long id) {
        SquadDTO squad = service.consultarPorId(id);
        if (squad != null) {
            return ResponseEntity.ok(squad);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<SquadDTO>> listarTodos() {
        List<SquadDTO> squads = service.listarTodos();
        return ResponseEntity.ok(squads);
    }

}
