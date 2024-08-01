package com.example.workflow_service.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class ItemLifeCycleUpdateRequest {

    private String itemLifeCycleStatus;

}
