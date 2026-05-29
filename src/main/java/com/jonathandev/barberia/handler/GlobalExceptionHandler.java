package com.jonathandev.barberia.handler;

import com.jonathandev.barberia.dto.ErrorResponseDto;
import com.jonathandev.barberia.exception.EmailEncontradoException;
import com.jonathandev.barberia.exception.EmailNaoEncontradoException;
import com.jonathandev.barberia.exception.UsuarioNaoEncontradoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EmailEncontradoException.class)
    public ResponseEntity<ErrorResponseDto> emailCadastradoHandler(EmailEncontradoException emailEncontrado){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(new ErrorResponseDto(409,"Email já cadastrado!", LocalDateTime.now()));
    }

    @ExceptionHandler(UsuarioNaoEncontradoException.class)
    public ResponseEntity<ErrorResponseDto> usuarionNaoEncontradoHandler(UsuarioNaoEncontradoException usuarioNaoEncontradoException){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponseDto(404,"Usuário não cadastrado",LocalDateTime.now()));
    }

    @ExceptionHandler(EmailNaoEncontradoException.class)
    public ResponseEntity<ErrorResponseDto> EmailNaoEncontradoHandler(EmailNaoEncontradoException emailNaoEncontradoException){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponseDto(404,"Email não cadastrado",LocalDateTime.now()));
    }
}
