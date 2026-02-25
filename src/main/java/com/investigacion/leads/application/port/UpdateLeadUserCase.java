package com.investigacion.leads.application.port;

import com.investigacion.leads.domain.model.Lead;
import com.investigacion.leads.infrastructure.input.dto.LeadRequestUpdate;

import java.util.UUID;

public interface UpdateLeadUserCase {
    Lead updateLead(UUID id, LeadRequestUpdate request);
}
