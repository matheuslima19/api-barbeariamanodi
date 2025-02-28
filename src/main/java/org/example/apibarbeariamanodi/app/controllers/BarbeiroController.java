package org.example.apibarbeariamanodi.app.controllers;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.apache.coyote.Response;
import org.example.apibarbeariamanodi.app.dtos.BarbeiroDTO.BarbeiroDTO;
import org.example.apibarbeariamanodi.app.dtos.BarbeiroDTO.CreateBarbeiroDTO;
import org.example.apibarbeariamanodi.app.dtos.BarbeiroDTO.LoginBarbeiroRequest;
import org.example.apibarbeariamanodi.app.dtos.BarbeiroDTO.LoginBarbeiroResponseDTO;
import org.example.apibarbeariamanodi.app.services.BarbeiroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/barbeiros")
@SecurityRequirement(name = "bearerAuth")
public class BarbeiroController {

    @Autowired
    private BarbeiroService barbeiroService;


    @PostMapping("/registrar")
    public ResponseEntity<BarbeiroDTO> registerBarbeiro(@RequestBody CreateBarbeiroDTO createBarbeiroDTO) {
        BarbeiroDTO barbeiroDTO = barbeiroService.register(createBarbeiroDTO);
        return new ResponseEntity<>(barbeiroDTO, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginBarbeiroResponseDTO> login(@RequestBody LoginBarbeiroRequest loginBarbeiroDTO) {
        LoginBarbeiroResponseDTO loginBarbeiroResponseDTO = barbeiroService.login(loginBarbeiroDTO);
        return ResponseEntity.ok(loginBarbeiroResponseDTO);
    }
}
