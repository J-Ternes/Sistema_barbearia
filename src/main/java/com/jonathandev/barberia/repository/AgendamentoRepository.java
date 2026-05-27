package com.jonathandev.barberia.repository;

import com.jonathandev.barberia.model.AgendamentoModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AgendamentoRepository extends JpaRepository<AgendamentoModel, UUID> {
}
