package com.investigacion.leads.infrastructure.output.repository;

import com.investigacion.leads.infrastructure.output.entity.LeadEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface LeadJpaRepository extends JpaRepository<LeadEntity, UUID> {
    LeadEntity save(LeadEntity lead);
    Optional<LeadEntity> findById(UUID id);
    List<LeadEntity> findAll();
    Optional<LeadEntity> findByNombre(String nombre);
    Optional<LeadEntity> findByEmail(String email);
}
