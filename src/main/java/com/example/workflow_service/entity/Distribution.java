package com.example.workflow_service.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@Builder
public class Distribution {
    private String distributionId;
    private String vendorNumber;
    private String itemHierarchy;
    private String distributionType;
    private String invoiceUnitIndicator;
    private ShipToStoreIndicator shipToStoreIndicator;
    private List<LocationStatus> statuses;
}
