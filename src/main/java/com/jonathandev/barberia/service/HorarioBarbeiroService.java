package com.jonathandev.barberia.service;

import com.jonathandev.barberia.dto.HorarioBarbeiroRegisterDto;
import com.jonathandev.barberia.dto.HorarioBarbeiroResponseDto;
import com.jonathandev.barberia.exception.BarbeiroNaoEncontradoException;
import com.jonathandev.barberia.exception.HorarioNaoEncontradoException;
import com.jonathandev.barberia.model.BarbeiroModel;
import com.jonathandev.barberia.model.HorarioBarbeariaModel;
import com.jonathandev.barberia.model.HorarioBarbeiroModel;
import com.jonathandev.barberia.repository.BarbeiroRepository;
import com.jonathandev.barberia.repository.HorarioBarbeiroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class HorarioBarbeiroService {

    private final BarbeiroRepository barbeiroRepository;
    private final HorarioBarbeiroRepository horarioBarbeiroRepository;

    public HorarioBarbeiroModel cadastrarHorario(HorarioBarbeiroRegisterDto horario){
       BarbeiroModel barbeiro = barbeiroRepository.findById(horario.barbeiro()).orElseThrow(()-> new BarbeiroNaoEncontradoException());

        HorarioBarbeiroModel horarios = new HorarioBarbeiroModel();
        horarios.setHorarioInicio(horario.horarioInicio());
        horarios.setHorarioFim(horario.horarioFim());
        horarios.setDiaDisponivel(horario.diaDisponivel());
        horarios.setBarbeiro(barbeiro);

        return horarioBarbeiroRepository.save(horarios);
    }

    public List<HorarioBarbeiroResponseDto> horariosCadastrados(){
       return horarioBarbeiroRepository.findAll().stream().map(horarios-> new HorarioBarbeiroResponseDto(
               horarios.getDiaDisponivel(),
               horarios.getHorarioInicio(),
               horarios.getHorarioFim(),
               horarios.getBarbeiro().getUsuario().getNome()
       )).toList();
    }

    public void deletarHorario(UUID id){
        HorarioBarbeiroModel horario = horarioBarbeiroRepository.findById(id).orElseThrow(()-> new HorarioNaoEncontradoException());

        horarioBarbeiroRepository.delete(horario);
    }
}
