package com.example.workflow_service.controller;

import com.example.workflow_service.entity.Distribution;
import com.example.workflow_service.service.DistributionService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DistributionController {

    private final DistributionService distributionService;

    public DistributionController(DistributionService distributionService){
        this.distributionService = distributionService;
    }

}
