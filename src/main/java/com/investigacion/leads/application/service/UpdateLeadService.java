package com.investigacion.leads.application.service;

import com.investigacion.leads.application.port.UpdateLeadUserCase;
import com.investigacion.leads.domain.model.EstadoLead;
import com.investigacion.leads.domain.model.Lead;
import com.investigacion.leads.domain.port.LeadRepositoryPort;
import com.investigacion.leads.domain.valueobject.Email;
import com.investigacion.leads.domain.valueobject.TrackingUTM;
import com.investigacion.leads.exception.BusinessException;
import com.investigacion.leads.infrastructure.input.dto.LeadRequestUpdate;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UpdateLeadService implements UpdateLeadUserCase {
    private final LeadRepositoryPort leadRepositoryPort;

    public UpdateLeadService(LeadRepositoryPort leadRepositoryPort) {
        this.leadRepositoryPort = leadRepositoryPort;
    }

    @Override
    public Lead updateLead(UUID id, LeadRequestUpdate request) {
        Lead existingLead = leadRepositoryPort.findById(id)
                .orElseThrow(() -> new BusinessException("Lead not found"));

        if (request.getName() != null) {
            existingLead.setNombre(request.getName());
        }

        if (request.getPhone() != null) {
            existingLead.setTelefono(request.getPhone());
        }

        if (request.getEmail() != null) {
            existingLead.setEmail(new Email(request.getEmail()));
        }
        if (request.getEstado() != null) {
            try {
                existingLead.setEstado(EstadoLead.from(request.getEstado()));
            } catch (IllegalArgumentException e) {
                throw new BusinessException("Invalid state: " + request.getEstado());
            }
        }
        return leadRepositoryPort.save(existingLead);
    }
}
