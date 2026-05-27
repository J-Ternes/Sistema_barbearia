package com.jonathandev.barberia.controller;

import com.jonathandev.barberia.dto.UserRegisterDto;
import com.jonathandev.barberia.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}
