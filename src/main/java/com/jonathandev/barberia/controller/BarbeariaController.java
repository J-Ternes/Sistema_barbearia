package com.jonathandev.barberia.controller;

import com.jonathandev.barberia.dto.BarbeariaRegisterDto;
import com.jonathandev.barberia.service.BarbeariaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/barbearia")
@RequiredArgsConstructor
public class BarbeariaController {

    private final BarbeariaService barbeariaService;

    @PostMapping
    public ResponseEntity cadastrar(@RequestBody BarbeariaRegisterDto barbearia){
        barbeariaService.criarBarbearia(barbearia);
        return ResponseEntity.status(HttpStatus.CREATED).body(barbearia);
    }

    @GetMapping("/cadastradas")
    public ResponseEntity barbearias(){

        return ResponseEntity.status(HttpStatus.FOUND).body(barbeariaService.mostrarBarbearias());

    }

}
