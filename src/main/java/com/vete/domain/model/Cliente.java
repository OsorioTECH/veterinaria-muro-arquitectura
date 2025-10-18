package com.vete.domain.model;

public class Cliente {
    private Long id;
    private String nombre;
    private String email;
    private String cedula;

    public Cliente() {}

    public Cliente(Long id, String nombre, String email, String cedula) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.cedula = cedula;
    }

    public Cliente(String nombre, String email, String cedula) {
        this(null, nombre, email, cedula);
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
