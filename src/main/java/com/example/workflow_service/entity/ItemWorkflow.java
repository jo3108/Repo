package com.example.workflow_service.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.ZonedDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@Document("itemworkflow")
public class ItemWorkflow {

    @Id
    private String id;
    private String itemId;
    private String workflowStatus;
    private Boolean maintain;
    private String lifeCycleStatus;
    private Integer groupCode;
    private Integer categoryCode;
    private String brandOwner;
    private String createdBy;

    private List<Distribution> distributions;
    private ZonedDateTime lastUpdateTs;
    private Lock lock;
}
