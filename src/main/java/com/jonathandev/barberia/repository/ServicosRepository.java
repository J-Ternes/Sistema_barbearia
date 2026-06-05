package com.jonathandev.barberia.repository;

import com.jonathandev.barberia.model.ServicosModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ServicosRepository extends JpaRepository<ServicosModel, UUID>{

    Optional<ServicosModel> findByNomeServico(String nome);
    Optional<ServicosModel> findById(UUID id);
}
