package com.investigacion.leads.infrastructure.output.repository;

import com.investigacion.leads.domain.model.Lead;
import com.investigacion.leads.domain.port.LeadRepositoryPort;
import com.investigacion.leads.infrastructure.output.entity.LeadEntity;
import com.investigacion.leads.infrastructure.output.mapper.LeadPersistenceMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Component
public class LeadRepositoryAdapter implements LeadRepositoryPort {
    private final LeadJpaRepository leadJpaRepository;

    public LeadRepositoryAdapter(LeadJpaRepository leadJpaRepository) {
        this.leadJpaRepository = leadJpaRepository;
    }

    @Override
    public Lead save(Lead lead) {
        LeadEntity saved = leadJpaRepository.save(LeadPersistenceMapper.toEntity(lead));
        return LeadPersistenceMapper.toDomain(saved);

    }

    @Override
    public Optional<Lead> findById(UUID id) {
        return leadJpaRepository.findById(id).map(LeadPersistenceMapper::toDomain);
    }

    @Override
    public List<Lead> findAll() {
        List<LeadEntity> leadEntities = leadJpaRepository.findAll();
        return leadEntities.stream().map(LeadPersistenceMapper::toDomain).toList();
    }

    @Override
    public Optional<Lead> findByNombre(String nombre) {
        return leadJpaRepository.findByNombre(nombre).map(LeadPersistenceMapper::toDomain);
    }

    @Override
    public Optional<Lead> findByEmail(String email) {
        return leadJpaRepository.findByEmail(email).map(LeadPersistenceMapper::toDomain);
    }

    @Override
    public void delete(Lead lead) {
        leadJpaRepository.delete(LeadPersistenceMapper.toEntity(lead));
    }
}

