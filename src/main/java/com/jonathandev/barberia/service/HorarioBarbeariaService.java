package com.jonathandev.barberia.service;

import com.jonathandev.barberia.dto.HorarioBarbeariaRegisterDto;
import com.jonathandev.barberia.dto.HorariosBarbeariaResponseDto;
import com.jonathandev.barberia.exception.BarbeariaNaoEncontradaException;
import com.jonathandev.barberia.exception.HorarioNaoEncontradoException;
import com.jonathandev.barberia.model.BarbeariaModel;
import com.jonathandev.barberia.model.HorarioBarbeariaModel;
import com.jonathandev.barberia.repository.BarbeariaRepository;
import com.jonathandev.barberia.repository.HorarioBarbeariaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class HorarioBarbeariaService {

    private final BarbeariaRepository barbeariaRepository;
    private final HorarioBarbeariaRepository horarioBarbeariaRepository;

    public HorarioBarbeariaModel cadastrarHorarios(HorarioBarbeariaRegisterDto horario){

       BarbeariaModel barbearia = barbeariaRepository.findById(horario.barbearia()).orElseThrow(()-> new BarbeariaNaoEncontradaException());

        HorarioBarbeariaModel horariosModel = new HorarioBarbeariaModel();
        horariosModel.setHorarioAbertura(horario.horarioAbertura());
        horariosModel.setHorarioAbertura(horario.horarioAbertura());
        horariosModel.setHorarioEncerramento(horario.horarioEncerramento());
        horariosModel.setBarbearia(barbearia);

        return horarioBarbeariaRepository.save(horariosModel);
    }

    public List<HorariosBarbeariaResponseDto> horariosCadastrados(){
        return horarioBarbeariaRepository.findAll().stream().map(horario -> new HorariosBarbeariaResponseDto(
                horario.getDiaFuncionamento(),
                horario.getHorarioAbertura(),
                horario.getHorarioEncerramento(),
                horario.getBarbearia().getNomeBarbearia()
        )).toList();
    }

    public void deletar(UUID id){

        HorarioBarbeariaModel horario = horarioBarbeariaRepository.findById(id).orElseThrow(()-> new HorarioNaoEncontradoException());

        horarioBarbeariaRepository.delete(horario);
    }
}
