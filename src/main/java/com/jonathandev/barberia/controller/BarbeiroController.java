package com.jonathandev.barberia.controller;

import com.jonathandev.barberia.dto.BarbeiroRegisterDto;
import com.jonathandev.barberia.model.BarbeiroModel;
import com.jonathandev.barberia.service.BarbeiroService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/barbeiros")
public class BarbeiroController {

    private final BarbeiroService barbeiroService;

    @PostMapping
    public ResponseEntity novoBarbeiro(@RequestBody @Valid BarbeiroRegisterDto barbeiro){
        BarbeiroModel novoBarbeiro = barbeiroService.cadastrarBarbeiro(barbeiro);

        return ResponseEntity.status(HttpStatus.CREATED).body(novoBarbeiro);
    }

    @GetMapping("/cadastrados")
    public ResponseEntity barbeiros(){

    }
}
