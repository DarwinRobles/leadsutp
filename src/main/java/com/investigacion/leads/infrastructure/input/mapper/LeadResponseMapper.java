package com.investigacion.leads.infrastructure.input.mapper;

import com.investigacion.leads.domain.model.Lead;
import com.investigacion.leads.infrastructure.input.dto.LeadResponse;

public class LeadResponseMapper {
    public static LeadResponse fromDomain(Lead lead) {
        return new LeadResponse(
                lead.getId().toString(),
                lead.getNombre(),
                lead.getTelefono(),
                lead.getEmail().getValue(),
                lead.getEstado().name(),
                lead.getTrackingUTM().getValue(),
                lead.getFechaCreacion().toString()
        );
    }
}
