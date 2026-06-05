package com.jonathandev.barberia.service;

import com.jonathandev.barberia.dto.ServicoRegisterDto;
import com.jonathandev.barberia.exception.BarbeariaNaoEncontradaException;
import com.jonathandev.barberia.exception.NomeServicoEncontradoException;
import com.jonathandev.barberia.model.BarbeariaModel;
import com.jonathandev.barberia.model.ServicosModel;
import com.jonathandev.barberia.repository.BarbeariaRepository;
import com.jonathandev.barberia.repository.ServicosRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ServicoService {

    private final ServicosRepository servicosRepository;
    private final BarbeariaRepository barbeariaRepository;

    public ServicosModel criarNovoServico(ServicoRegisterDto servicoDto){

        servicosRepository.findByNomeServico(servicoDto.nomeServico()).ifPresent(s -> new NomeServicoEncontradoException());
       BarbeariaModel barbearia = barbeariaRepository.findById(servicoDto.barbearia()).orElseThrow(()-> new BarbeariaNaoEncontradaException());

        ServicosModel servicoCriado = new ServicosModel();
        servicoCriado.setNomeServico(servicoDto.nomeServico());
        servicoCriado.setPrecoServico(servicoDto.precoServico());
        servicoCriado.setDuracaoServicoMinuto(servicoDto.duracaoServicoMinuto());
        servicoCriado.setDescricaoServico(servicoDto.descricao());
        servicoCriado.setBarbearia(barbearia);

       return  servicosRepository.save(servicoCriado);
    }

    public List<ServicoResponseDto> servicosCadastrados(){

    }


}
