package com.jonathandev.barberia.repository;

import com.jonathandev.barberia.model.BarbeariaModel;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.Optional;
import java.util.UUID;

public interface BarbeariaRepository extends JpaRepository<BarbeariaModel, UUID> {

    Optional<BarbeariaModel> findByCnpj(String cnpj);
    Optional<BarbeariaModel> findBynomeBarbearia(String nomeBarbearia);

 }
