package com.investigacion.leads.application.port;

import com.investigacion.leads.domain.model.Lead;

import java.util.UUID;

public interface UpdateLeadUserCase {
    Lead updateLead(UUID id, Lead lead);
}
