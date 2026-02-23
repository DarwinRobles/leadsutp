package com.investigacion.leads.application.service;

import com.investigacion.leads.application.port.UpdateLeadUserCase;
import com.investigacion.leads.domain.model.Lead;
import com.investigacion.leads.domain.port.LeadRepositoryPort;
import com.investigacion.leads.exception.BusinessException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UpdateLeadService implements UpdateLeadUserCase {
    private final LeadRepositoryPort leadRepositoryPort;

    public UpdateLeadService(LeadRepositoryPort leadRepositoryPort) {
        this.leadRepositoryPort = leadRepositoryPort;
    }

    @Override
    public Lead updateLead(UUID id, Lead lead) {
        Lead existingLead = leadRepositoryPort.findById(id)
                .orElseThrow(() -> new BusinessException("Lead not found"));

        if (lead.getNombre() != null) {
            existingLead.setNombre(lead.getNombre());
        }
        if (lead.getTelefono() != null) {
            existingLead.setTelefono(lead.getTelefono());
        }
        if (lead.getEmail() != null) {
            existingLead.setEmail(lead.getEmail());
        }
        if (lead.getEstado() != null) {
            existingLead.setEstado(lead.getEstado());
        }
        if (lead.getTrackingUTM() != null) {
            existingLead.setTrackingUTM(lead.getTrackingUTM());
        }
        return leadRepositoryPort.save(existingLead);
    }
}
