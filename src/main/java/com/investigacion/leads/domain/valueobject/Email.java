package com.investigacion.leads.domain.valueobject;

import com.investigacion.leads.exception.BusinessException;

import java.util.regex.Pattern;

public class Email {
    private final String value;

    private static final Pattern EMAIL_PATTERN =
            Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$");

    public Email(String value) {
        if (value == null || value.isBlank()) {
            throw new BusinessException("El email no puede ser null o vacío");
        }
        if (!EMAIL_PATTERN.matcher(value).matches()) {
            throw new BusinessException("Email inválido");
        }
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
