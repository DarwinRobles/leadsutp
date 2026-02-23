package com.investigacion.leads.domain.model;

import com.investigacion.leads.domain.valueobject.Email;
import com.investigacion.leads.domain.valueobject.TrackingUTM;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class Lead {
    private UUID id;
    private String nombre;
    private String telefono;
    private Email email;
    private EstadoLead estado;
    private TrackingUTM trackingUTM;
    private LocalDateTime fechaCreacion;

    public Lead() {}
}
