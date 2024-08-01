package com.example.workflow_service.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Builder
@ToString
public class LocationStatus {

    private String locationId;
    private String location;
    private String createdBy;
    private WorkflowState workflow;
    private String costArea;
    private String vendorSubAccount;
    private List<String> storeAuth;
    private String paymentTerms;
    private LocalDate beginAuthDate;

}
