package com.investigacion.leads.infrastructure.input.controller;

import com.investigacion.leads.application.port.*;
import com.investigacion.leads.domain.model.Lead;
import com.investigacion.leads.domain.port.LeadRepositoryPort;
import com.investigacion.leads.exception.BusinessException;
import com.investigacion.leads.infrastructure.input.dto.LeadRegisterRequest;
import com.investigacion.leads.infrastructure.input.dto.LeadResponse;
import com.investigacion.leads.infrastructure.input.dto.LeadResponseReport;
import com.investigacion.leads.infrastructure.input.mapper.LeadRequestMapper;
import com.investigacion.leads.infrastructure.input.mapper.LeadResponseMapper;
import com.investigacion.leads.response.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/leads")
public class LeadController {
    private final CrearLeadUseCase crearLeadUseCase;
    private final UpdateLeadUserCase updateLeadUserCase;
    private final DeleteLeadUserCase deleteLeadUserCase;
    private final GetAllLeadUseCase getAllLeadUseCase;
    private final GetReportsUseCase getReportsUseCase;


    public LeadController(CrearLeadUseCase crearLeadUseCase, UpdateLeadUserCase updateLeadUserCase,
                          DeleteLeadUserCase deleteLeadUserCase, LeadRepositoryPort leadRepositoryPort,
                          GetAllLeadUseCase getAllLeadUseCase, GetReportsUseCase getReportsUseCase) {
        this.crearLeadUseCase = crearLeadUseCase;
        this.updateLeadUserCase = updateLeadUserCase;
        this.deleteLeadUserCase = deleteLeadUserCase;
        this.getAllLeadUseCase = getAllLeadUseCase;
        this.getReportsUseCase = getReportsUseCase;
    }

    @PostMapping("/crear")
    public ResponseEntity<ApiResponse<LeadResponse>> crearLead(@RequestBody LeadRegisterRequest request ) {
            Lead lead = LeadRequestMapper.toDomain(request);
            Lead createdLead = crearLeadUseCase.crearLead(lead);

            LeadResponse leadResponse = LeadResponseMapper.fromDomain(createdLead);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(ApiResponse.success(
                            "Lead created",
                            leadResponse
                    ));

    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<ApiResponse<LeadResponse>> actualizarLead(@PathVariable UUID id, @RequestBody LeadRegisterRequest request) {
        Lead updatedLead = updateLeadUserCase.updateLead(id, LeadRequestMapper.toDomain(request));
        LeadResponse leadResponse = LeadResponseMapper.fromDomain(updatedLead);
        return ResponseEntity.status(HttpStatus.OK).body(ApiResponse.success("Lead updated", leadResponse));
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<ApiResponse<String>> eliminarLead(@PathVariable UUID id) {
        deleteLeadUserCase.deleteLead(id);
        return ResponseEntity.status(HttpStatus.OK).body(ApiResponse.success("Lead deleted", null));
    }

    @GetMapping("/all")
    public ResponseEntity<ApiResponse<List<LeadResponse>>> getAllLeads() {
        List<Lead> leads = getAllLeadUseCase.getAllLeads();
        List<LeadResponse> leadResponses = leads.stream()
                .map(LeadResponseMapper::fromDomain)
                .toList();
        return ResponseEntity.status(HttpStatus.OK).body(ApiResponse.success("All leads", leadResponses));
    }
    @GetMapping("/report")
    public ResponseEntity<ApiResponse<LeadResponseReport>> getGeneralReport() {
        LeadResponseReport report = getReportsUseCase.getGeneralReport();
        return ResponseEntity.status(HttpStatus.OK).body(ApiResponse.success("General report", report));
    }

    @GetMapping("/report/{date}")
    public ResponseEntity<ApiResponse<LeadResponseReport>> getReportByDate(@PathVariable String date) {
        LeadResponseReport report = getReportsUseCase.getReportByDate(date);
        return ResponseEntity.status(HttpStatus.OK).body(ApiResponse.success("Report for date " + date, report));
    }
}