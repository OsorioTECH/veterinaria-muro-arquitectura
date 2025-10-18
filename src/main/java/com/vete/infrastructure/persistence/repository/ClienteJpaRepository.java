package com.vete.infrastructure.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.vete.infrastructure.persistence.entity.ClienteEntity;
import java.util.Optional;

public interface ClienteJpaRepository extends JpaRepository<ClienteEntity, Long> {
    Optional<ClienteEntity> findByCedula(String cedula);
}
