package com.vete.application.cliente;

import com.vete.domain.model.Cliente;
import com.vete.domain.repository.ClienteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RegistrarClienteUseCase {
    private final ClienteRepository repo;

    public RegistrarClienteUseCase(ClienteRepository repo) { this.repo = repo; }

    @Transactional
    public Cliente registrar(String nombre, String email, String cedula) {
        // regla simple: no duplicar cédula
        repo.findByCedula(cedula).ifPresent(c -> {
            throw new IllegalArgumentException("Ya existe cliente con esa cédula");
        });
        Cliente nuevo = new Cliente(nombre, email, cedula);
        return repo.save(nuevo);
    }
}
