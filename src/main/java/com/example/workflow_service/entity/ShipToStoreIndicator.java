package com.example.workflow_service.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ShipToStoreIndicator {
    private String type;
    private String value;
}
