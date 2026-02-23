package com.investigacion.leads.application.service;

import com.investigacion.leads.application.port.CrearLeadUseCase;
import com.investigacion.leads.domain.model.Lead;
import com.investigacion.leads.domain.port.LeadRepositoryPort;
import com.investigacion.leads.exception.BusinessException;
import org.springframework.stereotype.Service;

@Service
public class LeadService implements CrearLeadUseCase {
    private final LeadRepositoryPort leadRepositoryPort;

    public LeadService(LeadRepositoryPort leadRepositoryPort) {
        this.leadRepositoryPort = leadRepositoryPort;
    }

    @Override
    public Lead crearLead(Lead lead) {
        if (leadRepositoryPort.findByEmail(lead.getEmail().getValue()).isPresent()) {
            throw new BusinessException("Lead already exists");
        }
        return leadRepositoryPort.save(lead);
    }
}
