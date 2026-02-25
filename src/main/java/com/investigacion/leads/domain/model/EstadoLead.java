package com.investigacion.leads.domain.model;

import com.investigacion.leads.exception.BusinessException;

public enum EstadoLead {
    NUEVO,
    CONTACTADO,
    CALIFICADO,
    EN_PROCESO,
    CONVERTIDO,
    DESCARTADO;

    public static EstadoLead from(String value) {
        for (EstadoLead estado : values()) {
            if (estado.name().equalsIgnoreCase(value)) {
                return estado;
            }
        }
        throw new BusinessException("Invalid Estado Lead: " + value);
    }
}

