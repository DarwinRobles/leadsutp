package com.investigacion.leads.application.port;

import com.investigacion.leads.infrastructure.input.dto.LeadResponseReport;

public interface GetReportsUseCase {
    LeadResponseReport getGeneralReport();
    LeadResponseReport getReportByDate(String date);;
}
