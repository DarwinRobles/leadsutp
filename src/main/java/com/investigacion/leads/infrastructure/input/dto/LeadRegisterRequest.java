package com.investigacion.leads.infrastructure.input.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LeadRegisterRequest {
    private String name;
    private String phone;
    private String email;
    private String estado;
    private String trackingUTM;
    private String fechaCreacion;

    public LeadRegisterRequest() {}
}
