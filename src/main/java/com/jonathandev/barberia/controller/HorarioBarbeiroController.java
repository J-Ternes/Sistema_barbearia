package com.jonathandev.barberia.controller;

import com.jonathandev.barberia.dto.HorarioBarbeiroRegisterDto;
import com.jonathandev.barberia.service.HorarioBarbeiroService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/horarios")
public class HorarioBarbeiroController {

    private final HorarioBarbeiroService horarioBarbeiroService;

    @PostMapping
    public ResponseEntity cadastro(@RequestBody @Valid HorarioBarbeiroRegisterDto horarios){
        return ResponseEntity.status(HttpStatus.CREATED).body(horarioBarbeiroService.cadastrarHorario(horarios));
    }

    @GetMapping("/cadastrados")
    public ResponseEntity horarios(){

    }
}
