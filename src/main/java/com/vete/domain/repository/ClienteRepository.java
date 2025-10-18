package com.vete.domain.repository;

import com.vete.domain.model.Cliente;
import java.util.List;
import java.util.Optional;

public interface ClienteRepository {
    Cliente save(Cliente c);
    Optional<Cliente> findById(Long id);
    Optional<Cliente> findByCedula(String cedula);
    List<Cliente> findAll();
}
