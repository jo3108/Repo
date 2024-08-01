package com.example.workflow_service.service;

import com.example.workflow_service.entity.Distribution;
import com.example.workflow_service.model.DistributionRequest;
import com.example.workflow_service.repository.ItemWorkflowRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class DistributionService {

    private final ItemWorkflowRepository itemWorkflowRepository;


    public DistributionService(ItemWorkflowRepository itemWorkflowRepository) {
        this.itemWorkflowRepository = itemWorkflowRepository;
    }



   // public Mono<List<Distribution>> updateDistributionConfiguration(DistributionRequest request){


    //}
}
