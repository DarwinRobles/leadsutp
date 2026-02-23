package com.investigacion.leads.infrastructure.output.entity;

import com.investigacion.leads.domain.model.EstadoLead;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "leads")
public class LeadEntity {

    @Id
    @GeneratedValue
    private UUID id;

    private String nombre;
    private String telefono;
    private String email;
    private EstadoLead estado;
    private String trackingUTM;
    private LocalDateTime fechaCreacion;
}
