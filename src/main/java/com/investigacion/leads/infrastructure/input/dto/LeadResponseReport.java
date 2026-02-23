package com.investigacion.leads.infrastructure.input.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class LeadResponseReport {
    private long totalLeads;
    private Map<String, Long> leadsByEstado;
    private Map<String, Long> leadsByDate;
    private Map<String, Long> leadsByUtmSource;

    public LeadResponseReport(
            long totalLeads,
            Map<String, Long> leadsByEstado,
            Map<String, Long> leadsByDate,
            Map<String, Long> leadsByUtmSource
    ) {
        this.totalLeads = totalLeads;
        this.leadsByEstado = leadsByEstado;
        this.leadsByDate = leadsByDate;
        this.leadsByUtmSource = leadsByUtmSource;
    }
}
