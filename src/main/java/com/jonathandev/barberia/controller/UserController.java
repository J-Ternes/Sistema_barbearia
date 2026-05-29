package com.jonathandev.barberia.controller;

import com.jonathandev.barberia.dto.UserRegisterDto;
import com.jonathandev.barberia.model.UserModel;
import com.jonathandev.barberia.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController{

    private final UserService userService;

    @PostMapping
    public ResponseEntity cadastrar(@RequestBody @Valid UserRegisterDto user){

        userService.cadastrarNovoUsuario(user);

        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @GetMapping("/usuarios")
    public ResponseEntity mostrarUsuarios(){
        return ResponseEntity.status(HttpStatus.FOUND).body(userService.mostrarUsuarios());

    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity deletarUsuario(@PathVariable UUID id) {
        userService.deletarUsuario(id);
        return ResponseEntity.noContent().build();
    }


}
