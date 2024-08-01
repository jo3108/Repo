package com.example.workflow_service.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ItemSave {
    private String id;
    private String itemId;
    private String workflowStatus;
    private Boolean maintain;
    private String lifeCycleStatus;
    private Integer groupCode;
    private Integer categoryCode;
    private String brandOwner;
    private String createdBy;
}
