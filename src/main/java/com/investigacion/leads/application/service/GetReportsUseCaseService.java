package com.investigacion.leads.application.service;

import com.investigacion.leads.application.port.GetReportsUseCase;
import com.investigacion.leads.domain.model.Lead;
import com.investigacion.leads.domain.port.LeadRepositoryPort;
import com.investigacion.leads.infrastructure.input.dto.LeadResponseReport;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service
public class GetReportsUseCaseService implements GetReportsUseCase {
    private final LeadRepositoryPort leadRepositoryPort;
    public GetReportsUseCaseService(LeadRepositoryPort leadRepositoryPort) {
        this.leadRepositoryPort = leadRepositoryPort;
    }

    @Override
    public LeadResponseReport getGeneralReport() {

        List<Lead> leads = leadRepositoryPort.findAll();

        long total = leads.size();

        Map<String, Long> byEstado = leads.stream()
                .collect(Collectors.groupingBy(
                        lead -> lead.getEstado().name(),
                        Collectors.counting()
                ));

        Map<String, Long> byDate = leads.stream()
                .collect(Collectors.groupingBy(
                        lead -> lead.getFechaCreacion().toLocalDate().toString(),
                        Collectors.counting()
                ));

        Map<String, Long> byUtmSource = leads.stream()
                .collect(Collectors.groupingBy(
                        lead -> extractUtmSource(lead.getTrackingUTM().getValue()),
                        Collectors.counting()
                ));

        return new LeadResponseReport(total, byEstado, byDate, byUtmSource);
    }

    private String extractUtmSource(String utm) {
        if (utm == null) return "UNKNOWN";

        return Arrays.stream(utm.split("&"))
                .filter(p -> p.startsWith("utm_source="))
                .map(p -> p.split("=")[1])
                .findFirst()
                .orElse("UNKNOWN");
    }

    @Override
    public LeadResponseReport getReportByDate(String date) {

        LocalDate targetDate = LocalDate.parse(date);

        List<Lead> leads = leadRepositoryPort.findAll().stream()
                .filter(lead -> lead.getFechaCreacion().toLocalDate().equals(targetDate))
                .toList();

        return buildReport(leads);
    }

    private LeadResponseReport buildReport(List<Lead> leads) {
        Map<String, Long> leadsByEstado = leads.stream()
                .collect(Collectors.groupingBy(
                        lead -> lead.getEstado().name(),
                        Collectors.counting()
                ));
        Map<String, Long> leadsByDate = Map.of(leads.get(0).getFechaCreacion().toLocalDate().toString(), (long) leads.size());
        Map<String, Long> leadsByUtmSource = leads.stream()
                .collect(Collectors.groupingBy(
                        lead -> extractUtmSource(lead.getTrackingUTM().getValue()),
                        Collectors.counting()
                ));
        return new LeadResponseReport(
                leads.size(),
                leadsByEstado,
                leadsByDate,
                leadsByUtmSource
        );
    }
}