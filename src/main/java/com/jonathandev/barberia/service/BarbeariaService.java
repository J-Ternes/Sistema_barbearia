package com.jonathandev.barberia.service;

import com.jonathandev.barberia.dto.BarbeariaRegisterDto;
import com.jonathandev.barberia.dto.BarbeariaResponseDto;
import com.jonathandev.barberia.exception.BarbeariaNaoEncontradaException;
import com.jonathandev.barberia.exception.CnpjEncontradoException;
import com.jonathandev.barberia.exception.NomeEncontradoException;
import com.jonathandev.barberia.model.BarbeariaModel;
import com.jonathandev.barberia.repository.BarbeariaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BarbeariaService {

    private final BarbeariaRepository barbeariaRepository;

    public BarbeariaModel criarBarbearia(BarbeariaRegisterDto barbeariaRegisterDto){
        barbeariaRepository.findByCnpj(barbeariaRegisterDto.cnpj()).ifPresent(b-> {throw new CnpjEncontradoException();});
        barbeariaRepository.findBynomeBarbearia(barbeariaRegisterDto.nomeBarbearia()).ifPresent(b->{throw new NomeEncontradoException();});

        BarbeariaModel barbeariaModel = new BarbeariaModel();
        barbeariaModel.setNomeBarbearia(barbeariaRegisterDto.nomeBarbearia());
        barbeariaModel.setCnpj(barbeariaRegisterDto.cnpj());

        return barbeariaRepository.save(barbeariaModel);
    }

    public List<BarbeariaResponseDto> mostrarBarbearias (){
        return barbeariaRepository.findAll().stream().map(barbearia -> new BarbeariaResponseDto(
                barbearia.getNomeBarbearia()
        )).toList();
    }

    public void deletarBarbearia(UUID id){
        BarbeariaModel barbearia = barbeariaRepository.findById(id).orElseThrow(()-> new BarbeariaNaoEncontradaException());
        barbeariaRepository.delete(barbearia);
    }


}
