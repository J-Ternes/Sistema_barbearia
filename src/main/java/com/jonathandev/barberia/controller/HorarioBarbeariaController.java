package com.jonathandev.barberia.controller;

import com.jonathandev.barberia.dto.HorarioBarbeariaRegisterDto;
import com.jonathandev.barberia.service.HorarioBarbeariaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/horarios/barbearia")
public class HorarioBarbeariaController {

    private final HorarioBarbeariaService horarioBarbeariaService;


    @PostMapping
    public ResponseEntity criarHorario(@RequestBody @Valid HorarioBarbeariaRegisterDto horario){
        return ResponseEntity.status(HttpStatus.CREATED).body(horarioBarbeariaService.cadastrarHorarios(horario));
    }

    @GetMapping("/cadastrados")
    public ResponseEntity horarios(){
        return ResponseEntity.status(HttpStatus.OK).body(horarioBarbeariaService.horariosCadastrados());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deletar(UUID id){
        horarioBarbeariaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
