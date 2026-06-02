package com.jonathandev.barberia.controller;

import com.jonathandev.barberia.dto.BarbeariaRegisterDto;
import com.jonathandev.barberia.service.BarbeariaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/barbearia")
@RequiredArgsConstructor
public class BarbeariaController {

    private final BarbeariaService barbeariaService;

    @PostMapping
    public ResponseEntity cadastrar(@RequestBody @Valid BarbeariaRegisterDto barbearia){
        barbeariaService.criarBarbearia(barbearia);
        return ResponseEntity.status(HttpStatus.CREATED).body(barbearia);
    }

    @GetMapping("/cadastradas")
    public ResponseEntity barbearias(){
        return ResponseEntity.status(HttpStatus.FOUND).body(barbeariaService.mostrarBarbearias());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable UUID id){
        barbeariaService.deletarBarbearia(id);
        return ResponseEntity.noContent().build();
    }

}
