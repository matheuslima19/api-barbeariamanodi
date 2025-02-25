package org.example.apibarbeariamanodi.app.controllers;

import org.example.apibarbeariamanodi.app.dtos.AgendaBarbeiroDTO;
import org.example.apibarbeariamanodi.app.services.AgendaBarbeiroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agenda")
public class AgendaBarbeiroController {

    @Autowired
    private AgendaBarbeiroService agendaBarbeiroService;

    @GetMapping
    public ResponseEntity<List<AgendaBarbeiroDTO>> listarTodos() {
        return ResponseEntity.ok(agendaBarbeiroService.listarAgendas());
    }

    @PostMapping
    public ResponseEntity<AgendaBarbeiroDTO> criar(@RequestBody AgendaBarbeiroDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(agendaBarbeiroService.salvarAgenda(dto));
    }
}

