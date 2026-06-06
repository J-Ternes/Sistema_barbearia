package com.jonathandev.barberia.handler;

import com.jonathandev.barberia.dto.ErrorResponseDto;
import com.jonathandev.barberia.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponseException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
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

    @ExceptionHandler(BarbeiroNaoEncontradoException.class)
    public ResponseEntity<ErrorResponseDto> barbeiroNaoEncontradoHandler(BarbeiroNaoEncontradoException barbeiroNaoEncontradoException){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponseDto(404,"Barbeiro não cadastrado",LocalDateTime.now()));
    }

    @ExceptionHandler(BarbeiroEncontradoException.class)
    public ResponseEntity<ErrorResponseDto> barbeiroEncontradoHandler(BarbeiroEncontradoException barbeiroEncontradoException){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(new ErrorResponseDto(409,"CPF já cadastrado",LocalDateTime.now()));
    }

    @ExceptionHandler(NomeServicoEncontradoException.class)
    public ResponseEntity<ErrorResponseDto> servicoEncontradoHandler(NomeServicoEncontradoException servicoEncontradoException){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(new ErrorResponseDto(409,"Esse nome de Servico já existe",LocalDateTime.now()));
    }

    @ExceptionHandler(ServicoNaoEncontradoException.class)
    public ResponseEntity<ErrorResponseDto> servicoNaoEncontradoHandler(ServicoNaoEncontradoException servicoNaoEncontradoException){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponseDto(404,"Serviço não cadastrado",LocalDateTime.now()));
    }

    @ExceptionHandler(HorarioNaoEncontradoException.class)
    public ResponseEntity<ErrorResponseDto> horarioNaoEncontradoHandler(HorarioNaoEncontradoException horarioNaoEncontradoException){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponseDto(404,"Horário não cadastrado",LocalDateTime.now()));
    }
}
