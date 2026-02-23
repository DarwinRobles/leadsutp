package com.investigacion.leads.domain.valueobject;

import com.investigacion.leads.exception.BusinessException;

public class TrackingUTM {
    private final String value;

    public TrackingUTM(String value) {
        if (!value.contains("utm_source=")) {
            throw new BusinessException("UTM inválido");
        }
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
