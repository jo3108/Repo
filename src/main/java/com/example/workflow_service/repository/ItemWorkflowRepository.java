package com.example.workflow_service.repository;

import com.example.workflow_service.entity.ItemWorkflow;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface ItemWorkflowRepository extends ReactiveMongoRepository<ItemWorkflow,String> {

    Mono<ItemWorkflow> findByItemId(String itemId);
}
