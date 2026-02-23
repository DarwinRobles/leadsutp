package com.investigacion.leads.application.port;

import com.investigacion.leads.domain.model.Lead;

public interface CrearLeadUseCase {
    Lead crearLead(Lead lead);
}
