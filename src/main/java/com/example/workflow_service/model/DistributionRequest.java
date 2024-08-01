package com.example.workflow_service.model;

import com.example.workflow_service.entity.Distribution;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class DistributionRequest {

    private String itemId;
    private String distributionId;
    private Distribution oldConfiguration;
    private Distribution newConfiguration;
}
