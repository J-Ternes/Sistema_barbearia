package com.jonathandev.barberia.repository;

import com.jonathandev.barberia.model.BarbeiroModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BarbeiroRepository extends JpaRepository<BarbeiroModel, UUID> {
}
