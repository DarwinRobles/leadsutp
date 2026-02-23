package com.investigacion.leads.infrastructure.output.mapper;

import com.investigacion.leads.domain.model.Lead;
import com.investigacion.leads.domain.valueobject.Email;
import com.investigacion.leads.domain.valueobject.TrackingUTM;
import com.investigacion.leads.infrastructure.output.entity.LeadEntity;


public class LeadPersistenceMapper {
    public static LeadEntity toEntity(Lead lead) {
        LeadEntity entity = new LeadEntity();
        entity.setId(lead.getId());
        entity.setNombre(lead.getNombre());
        entity.setTelefono(lead.getTelefono());
        entity.setEmail(lead.getEmail().getValue());
        entity.setEstado(lead.getEstado());
        entity.setTrackingUTM(lead.getTrackingUTM().getValue());
        entity.setFechaCreacion(lead.getFechaCreacion());
        return entity;
    }

    public static Lead toDomain(LeadEntity entity) {
        Lead lead = new Lead();
        lead.setId(entity.getId());
        lead.setNombre(entity.getNombre());
        lead.setTelefono(entity.getTelefono());
        lead.setEmail(new Email(entity.getEmail()));
        lead.setEstado(entity.getEstado());
        lead.setTrackingUTM(new TrackingUTM(entity.getTrackingUTM()));
        lead.setFechaCreacion(entity.getFechaCreacion());
        return lead;
    }
}
