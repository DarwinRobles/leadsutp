package com.investigacion.leads.infrastructure.input.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LeadResponse {
    private String id;
    private String name;
    private String phone;
    private String email;
    private String estado;
    private String trackingUTM;
    private String fechaCreacion;

    public LeadResponse(String id, String name, String phone, String email, String estado, String trackingUTM, String fechaCreacion) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.estado = estado;
        this.trackingUTM = trackingUTM;
        this.fechaCreacion = fechaCreacion;
    }
}
