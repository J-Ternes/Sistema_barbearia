package com.jonathandev.barberia.service;

import com.jonathandev.barberia.dto.BarbeiroRegisterDto;
import com.jonathandev.barberia.exception.BarbeariaNaoEncontradaException;
import com.jonathandev.barberia.exception.UsuarioNaoEncontradoException;
import com.jonathandev.barberia.model.BarbeariaModel;
import com.jonathandev.barberia.model.BarbeiroModel;
import com.jonathandev.barberia.model.UserModel;
import com.jonathandev.barberia.repository.BarbeariaRepository;
import com.jonathandev.barberia.repository.BarbeiroRepository;
import com.jonathandev.barberia.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BarbeiroService {

    private final BarbeiroRepository barbeiroRepository;
    private final UserRepository userRepository;
    private final BarbeariaRepository barbeariaRepository;

    @Transactional //Tudo ou nada -> Se em algum momento do código ocorrer uma falha, ele cancela tudo
    public BarbeiroModel cadastrarBarbeiro(BarbeiroRegisterDto barbeiro)
    {
        UserModel user = userRepository.findById(barbeiro.userId()).orElseThrow(()-> new UsuarioNaoEncontradoException());
        BarbeariaModel barbearia = barbeariaRepository.findById(barbeiro.barbeariaId()).orElseThrow(()-> new BarbeariaNaoEncontradaException());

        BarbeiroModel novoBarbeiro = new BarbeiroModel();
        novoBarbeiro.setUsuario(user);
        novoBarbeiro.setBarbearia(barbearia);
        novoBarbeiro.setCpf(barbeiro.cpf());

        return barbeiroRepository.save(novoBarbeiro);
    }
}
