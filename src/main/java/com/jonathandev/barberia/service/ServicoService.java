package com.jonathandev.barberia.service;


import com.jonathandev.barberia.dto.ServicoRegisterDto;
import com.jonathandev.barberia.dto.ServicoResponseDto;
import com.jonathandev.barberia.dto.ServicoUpdateNomeDto;
import com.jonathandev.barberia.exception.BarbeariaNaoEncontradaException;
import com.jonathandev.barberia.exception.NomeServicoEncontradoException;
import com.jonathandev.barberia.exception.ServicoNaoEncontradoException;
import com.jonathandev.barberia.model.BarbeariaModel;
import com.jonathandev.barberia.model.ServicosModel;
import com.jonathandev.barberia.repository.BarbeariaRepository;
import com.jonathandev.barberia.repository.ServicosRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


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
        List<ServicoResponseDto> servicos = servicosRepository.findAll().stream().map(servico-> new ServicoResponseDto(
                servico.getNomeServico(), servico.getPrecoServico(), servico.getDuracaoServicoMinuto(), servico.getDescricaoServico()
        )).toList();

        return servicos;
    }

    public void deletarServico(UUID id){
        ServicosModel servico = servicosRepository.findById(id).orElseThrow(()-> new ServicoNaoEncontradoException());

        servicosRepository.delete(servico);
    }

    public ServicosModel alterarNome(ServicoUpdateNomeDto novoNome, UUID id){
        ServicosModel servicoNovoNome = servicosRepository.findById(id).orElseThrow(()-> new ServicoNaoEncontradoException());
        servicosRepository.findByNomeServico(novoNome.nome()).ifPresent(s-> new NomeServicoEncontradoException());

        servicoNovoNome.setNomeServico(novoNome.nome());

        return servicosRepository.save(servicoNovoNome);

    }


}
