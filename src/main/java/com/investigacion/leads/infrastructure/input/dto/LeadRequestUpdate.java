package com.investigacion.leads.infrastructure.input.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LeadRequestUpdate {
    private String name;
    private String phone;
    private String email;
    private String estado;

    public LeadRequestUpdate() {}
}
