package com.vete.application.cliente;

import com.vete.domain.model.Cliente;
import com.vete.domain.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListarClientesUseCase {
    private final ClienteRepository repo;

    public ListarClientesUseCase(ClienteRepository repo) { this.repo = repo; }

    public List<Cliente> listar() {
        return repo.findAll();
    }
}
