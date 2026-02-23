package com.investigacion.leads.application.service;

import com.investigacion.leads.application.port.GetAllLeadUseCase;
import com.investigacion.leads.domain.model.Lead;
import com.investigacion.leads.domain.port.LeadRepositoryPort;
import com.investigacion.leads.exception.BusinessException;
import com.investigacion.leads.infrastructure.input.mapper.LeadResponseMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllLeadService implements GetAllLeadUseCase {
    private final LeadRepositoryPort leadRepositoryPort;

    public GetAllLeadService(LeadRepositoryPort leadRepositoryPort) {
        this.leadRepositoryPort = leadRepositoryPort;
    }

    @Override
    public List<Lead> getAllLeads() {
        if (leadRepositoryPort.findAll().isEmpty()) {
            throw new BusinessException("No leads found");
        }
        return leadRepositoryPort.findAll();
    }
}
