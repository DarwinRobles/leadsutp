package com.investigacion.leads.application.port;


import com.investigacion.leads.domain.model.Lead;

import java.util.List;

public interface GetAllLeadUseCase {
    List<Lead> getAllLeads();
}
