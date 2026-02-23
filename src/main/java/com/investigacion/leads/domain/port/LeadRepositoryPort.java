package com.investigacion.leads.domain.port;

import com.investigacion.leads.domain.model.Lead;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface LeadRepositoryPort {
    Lead save(Lead lead);

    Optional<Lead> findById(UUID id);

    List<Lead> findAll();

    Optional<Lead> findByNombre(String nombre);

    Optional<Lead> findByEmail(String email);

    void delete(Lead lead);
}
