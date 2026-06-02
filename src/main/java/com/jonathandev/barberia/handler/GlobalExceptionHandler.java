package com.jonathandev.barberia.handler;

import com.jonathandev.barberia.dto.ErrorResponseDto;
import com.jonathandev.barberia.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponseException;
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

    @ExceptionHandler( CnpjEncontradoException.class)
    public ResponseEntity<ErrorResponseDto>  CnpjEncontradoHandler(CnpjEncontradoException cnpjEncontradoException){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(new ErrorResponseDto(409, "CNPJ já cadastrado", LocalDateTime.now()));
    }

    @ExceptionHandler(NomeEncontradoException.class)
    public ResponseEntity<ErrorResponseDto> NomeEncontradoHandler(NomeEncontradoException nomeEncontradoException){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(new ErrorResponseDto(409,"Nome já cadastrado", LocalDateTime.now()));
    }

    @ExceptionHandler(BarbeariaNaoEncontradaException.class)
    public ResponseEntity<ErrorResponseDto> barbeariaNaoEncontradaHandler(BarbeariaNaoEncontradaException barbeariaNaoEncontradaException){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponseDto(404,"Barbearia não cadastrado",LocalDateTime.now()));
    }
}
