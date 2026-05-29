package com.jonathandev.barberia.service;

import com.jonathandev.barberia.dto.UserRegisterDto;
import com.jonathandev.barberia.dto.UserResponseDto;
import com.jonathandev.barberia.exception.EmailEncontradoException;
import com.jonathandev.barberia.exception.UsuarioNaoEncontradoException;
import com.jonathandev.barberia.model.UserEnum;
import com.jonathandev.barberia.model.UserModel;
import com.jonathandev.barberia.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserModel cadastrarNovoUsuario(UserRegisterDto user){
        UserModel emailCadastrado = userRepository.findByEmail(user.email()).orElseThrow(()-> new EmailEncontradoException());

        UserModel novoUsuario = new UserModel();
        novoUsuario.setNome(user.nome());
        novoUsuario.setEmail(user.email());
        novoUsuario.setSenha(user.senha());
        novoUsuario.setRole(UserEnum.CLIENTE);

       return userRepository.save(novoUsuario);
    }

    public List<UserResponseDto> mostrarUsuarios(){
        return  userRepository.findByAll().stream().map(user -> new UserResponseDto(
                user.getNome(),user.getRole())).toList();
    }

    public void deletarUsuario(UUID id){
        UserModel usuario = userRepository.findById(id).orElseThrow(()-> new UsuarioNaoEncontradoException());
        userRepository.delete(usuario);
    }
}
