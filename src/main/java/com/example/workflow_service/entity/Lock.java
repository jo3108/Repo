package com.example.workflow_service.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;
@Getter
@Setter
@Builder
public class Lock {
    private String lockedBy;
    private ZonedDateTime localDate;
    private String authRole;

}
