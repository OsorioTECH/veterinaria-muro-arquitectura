package com.vete.infrastructure.persistence.adapter;

import org.springframework.stereotype.Component;
import com.vete.domain.model.Cliente;
import com.vete.domain.repository.ClienteRepository;
import com.vete.infrastructure.persistence.entity.ClienteEntity;
import com.vete.infrastructure.persistence.repository.ClienteJpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ClienteRepositoryAdapter implements ClienteRepository {

    private final ClienteJpaRepository jpa;

    public ClienteRepositoryAdapter(ClienteJpaRepository jpa) {
        this.jpa = jpa;
    }

    private Cliente toDomain(ClienteEntity e) {
        return new Cliente(e.getId(), e.getNombre(), e.getEmail(), e.getCedula());
    }

    private ClienteEntity toEntity(Cliente d) {
        ClienteEntity e = new ClienteEntity();
        e.setId(d.getId());
        e.setNombre(d.getNombre());
        e.setEmail(d.getEmail());
        e.setCedula(d.getCedula());
        return e;
    }

    @Override
    public Cliente save(Cliente c) {
        ClienteEntity saved = jpa.save(toEntity(c));
        return toDomain(saved);
    }

    @Override
    public Optional<Cliente> findById(Long id) {
        return jpa.findById(id).map(this::toDomain);
    }

    @Override
    public Optional<Cliente> findByCedula(String cedula) {
        return jpa.findByCedula(cedula).map(this::toDomain);
    }

    @Override
    public List<Cliente> findAll() {
        return jpa.findAll().stream().map(this::toDomain).collect(Collectors.toList());
    }
}
