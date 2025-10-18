package com.vete.infrastructure.persistence.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "clientes", uniqueConstraints = @UniqueConstraint(columnNames = "cedula"))
public class ClienteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String email;
    private String cedula;

    public ClienteEntity() {}

    public ClienteEntity(String nombre, String email, String cedula) {
        this.nombre = nombre;
        this.email = email;
        this.cedula = cedula;
    }

    // getters y setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getCedula() { return cedula; }
    public void setCedula(String cedula) { this.cedula = cedula; }
}
