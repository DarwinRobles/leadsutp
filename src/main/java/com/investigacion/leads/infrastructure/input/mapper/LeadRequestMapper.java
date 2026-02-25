package com.investigacion.leads.infrastructure.input.mapper;

import com.investigacion.leads.domain.model.EstadoLead;
import com.investigacion.leads.domain.model.Lead;
import com.investigacion.leads.domain.valueobject.Email;
import com.investigacion.leads.domain.valueobject.TrackingUTM;
import com.investigacion.leads.infrastructure.input.dto.LeadRegisterRequest;
import com.investigacion.leads.infrastructure.input.dto.LeadRequestUpdate;

import java.time.LocalDateTime;

public class LeadRequestMapper {
    public static Lead toDomain(LeadRegisterRequest request) {
        Lead lead = new Lead();
        lead.setNombre(request.getName());
        lead.setTelefono(request.getPhone());
        lead.setEmail(new Email(request.getEmail()));
        lead.setEstado(EstadoLead.NUEVO);
        lead.setTrackingUTM( new TrackingUTM(request.getTrackingUTM()));
        lead.setFechaCreacion(LocalDateTime.now());
        return lead;
    }

    public static Lead toDomain(LeadRequestUpdate request) {
        Lead lead = new Lead();
        lead.setNombre(request.getName());
        lead.setTelefono(request.getPhone());
        lead.setEmail(new Email(request.getEmail()));
        lead.setEstado(EstadoLead.valueOf(request.getEstado()));
        return lead;
    }
}
