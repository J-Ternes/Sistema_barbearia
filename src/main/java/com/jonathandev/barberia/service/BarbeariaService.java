package com.jonathandev.barberia.service;

import com.jonathandev.barberia.dto.BarbeariaRegisterDto;
import com.jonathandev.barberia.exception.CnpjEncontradoException;
import com.jonathandev.barberia.exception.NomeEncontradoException;
import com.jonathandev.barberia.model.BarbeariaModel;
import com.jonathandev.barberia.repository.BarbeariaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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


}
