package com.vete.api.controller;

import com.vete.application.cliente.ListarClientesUseCase;
import com.vete.application.cliente.RegistrarClienteUseCase;
import com.vete.domain.model.Cliente;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final RegistrarClienteUseCase registrarUseCase;
    private final ListarClientesUseCase listarUseCase;

    public ClienteController(RegistrarClienteUseCase registrarUseCase, ListarClientesUseCase listarUseCase) {
        this.registrarUseCase = registrarUseCase;
        this.listarUseCase = listarUseCase;
    }

    record ClienteRequest(@NotBlank String nombre, @NotBlank String email, @NotBlank String cedula) {}

    record ClienteResponse(Long id, String nombre, String email, String cedula) {
        public static ClienteResponse fromDomain(Cliente c) {
            return new ClienteResponse(c.getId(), c.getNombre(), c.getEmail(), c.getCedula());
        }
    }

    @PostMapping
    public ResponseEntity<ClienteResponse> crear(@Valid @RequestBody ClienteRequest req) {
        Cliente creado = registrarUseCase.registrar(req.nombre(), req.email(), req.cedula());
        var resp = ClienteResponse.fromDomain(creado);
        return ResponseEntity.created(URI.create("/clientes/" + resp.id())).body(resp);
    }

    @GetMapping
    public ResponseEntity<List<ClienteResponse>> listar() {
        var lista = listarUseCase.listar().stream().map(ClienteResponse::fromDomain).toList();
        return ResponseEntity.ok(lista);
    }
}
