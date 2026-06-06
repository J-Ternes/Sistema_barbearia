package com.jonathandev.barberia.service;

import com.jonathandev.barberia.dto.HorarioBarbeiroRegisterDto;
import com.jonathandev.barberia.exception.BarbeiroNaoEncontradoException;
import com.jonathandev.barberia.model.BarbeiroModel;
import com.jonathandev.barberia.model.HorarioBarbeariaModel;
import com.jonathandev.barberia.model.HorarioBarbeiroModel;
import com.jonathandev.barberia.repository.BarbeiroRepository;
import com.jonathandev.barberia.repository.HorarioBarbeiroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
}
