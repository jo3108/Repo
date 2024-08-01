package com.example.workflow_service.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class ItemLifeCycleUpdateResponse {

    private String oldItemLifeCycleStatus;
    private String newItemLifeCycleStatus;
}
