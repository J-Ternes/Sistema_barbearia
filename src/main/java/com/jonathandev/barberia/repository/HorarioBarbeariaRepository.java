package com.jonathandev.barberia.repository;

import com.jonathandev.barberia.model.HorarioBarbeariaModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface HorarioBarbeariaRepository extends JpaRepository<HorarioBarbeariaModel, UUID> {
}
