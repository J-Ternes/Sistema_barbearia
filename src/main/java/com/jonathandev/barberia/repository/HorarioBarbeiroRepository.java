package com.jonathandev.barberia.repository;

import com.jonathandev.barberia.model.HorarioBarbeiroModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface HorarioBarbeiroRepository extends JpaRepository<HorarioBarbeiroModel, UUID> {
}
