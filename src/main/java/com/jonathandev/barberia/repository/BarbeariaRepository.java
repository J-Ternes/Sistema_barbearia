package com.jonathandev.barberia.repository;

import com.jonathandev.barberia.model.BarbeariaModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BarbeariaRepository extends JpaRepository<BarbeariaModel, UUID> {
}
