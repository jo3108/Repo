package com.example.workflow_service.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class WorkflowState {
    private String currentStatus;
    private String previousStatus;
    private String revisionFrom;
}
