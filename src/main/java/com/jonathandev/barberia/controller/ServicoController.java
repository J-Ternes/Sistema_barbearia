package com.jonathandev.barberia.controller;

import com.jonathandev.barberia.dto.ServicoRegisterDto;
import com.jonathandev.barberia.model.ServicosModel;
import com.jonathandev.barberia.service.ServicoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/servicos")
@RequiredArgsConstructor
public class ServicoController {

    private final ServicoService servicoService;

    @PostMapping
    public ResponseEntity novoServico(@RequestBody @Valid ServicoRegisterDto servico){
        ServicosModel servicoCriado = servicoService.criarNovoServico(servico);

        return ResponseEntity.status(HttpStatus.CREATED).body(servicoCriado);
    }

    @GetMapping("/cadastrados")
    public ResponseEntity servicos(){
        return ResponseEntity.status(HttpStatus.OK).body(servicoService.servicosCadastrados());
    }


}
