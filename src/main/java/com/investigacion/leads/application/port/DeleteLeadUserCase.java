package com.investigacion.leads.application.port;

import java.util.UUID;

public interface DeleteLeadUserCase {
    void deleteLead(UUID id);
}
