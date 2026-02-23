package com.investigacion.leads.application.service;

import com.investigacion.leads.application.port.DeleteLeadUserCase;
import com.investigacion.leads.domain.model.Lead;
import com.investigacion.leads.domain.port.LeadRepositoryPort;
import com.investigacion.leads.exception.BusinessException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DeleteLeadService implements DeleteLeadUserCase {
    private final LeadRepositoryPort leadRepositoryPort;

    public DeleteLeadService(LeadRepositoryPort leadRepositoryPort) {
        this.leadRepositoryPort = leadRepositoryPort;
    }

    @Override
    public void deleteLead(UUID id) {
        Lead lead = leadRepositoryPort.findById(id)
                .orElseThrow(() -> new BusinessException("Lead not found"));
        leadRepositoryPort.delete(lead);
    }
}
