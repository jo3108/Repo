package com.example.workflow_service.service;

import com.example.workflow_service.constants.ItemLifeCycleStatus;
import com.example.workflow_service.entity.ItemWorkflow;
import com.example.workflow_service.exception.WorkflowProgressException;
import com.example.workflow_service.model.ItemLifeCycleUpdateResponse;
import com.example.workflow_service.model.ItemSave;
import com.example.workflow_service.repository.ItemWorkflowRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.concurrent.atomic.AtomicReference;

@Service
public class ItemLifeCycleService {

    private final ItemWorkflowRepository itemWorkflowRepository;

    public ItemLifeCycleService(ItemWorkflowRepository itemWorkflowRepository){
        this.itemWorkflowRepository = itemWorkflowRepository;
    }

    public void save(ItemSave itemSave){

        ItemWorkflow itemWorkflow = ItemWorkflow.builder().id(itemSave.getId())
                .itemId(itemSave.getItemId())
                .workflowStatus(itemSave.getWorkflowStatus())
                .lifeCycleStatus(itemSave.getLifeCycleStatus())
                .categoryCode(itemSave.getCategoryCode())
                .groupCode(itemSave.getGroupCode()).build();
        itemWorkflowRepository.save(itemWorkflow);

    }



    public Mono<ItemLifeCycleUpdateResponse> update(String itemId, ItemLifeCycleStatus itemLifeCycleStatus){

        AtomicReference<String> oldLifeCycleStatus = new AtomicReference<>();

        return itemWorkflowRepository.findByItemId(itemId)
                .map(itemWorkflow -> {
            ItemLifeCycleStatus existingStatus = ItemLifeCycleStatus.from(itemWorkflow.getLifeCycleStatus());
            oldLifeCycleStatus.set(existingStatus.toString());
            if(itemLifeCycleStatus ==ItemLifeCycleStatus.READY_TO_SELL&&itemLifeCycleStatus==ItemLifeCycleStatus.READY_TO_ORDER){
                itemWorkflow.setLifeCycleStatus(itemLifeCycleStatus.toString());
            }
            return itemWorkflow;
                }).flatMap(itemWorkflowRepository::save)
                .map(itemWorkflow -> {
                    ItemLifeCycleUpdateResponse itemLifeCycleUpdateResponse = ItemLifeCycleUpdateResponse.builder()
                            .newItemLifeCycleStatus(itemWorkflow.getLifeCycleStatus())
                            .oldItemLifeCycleStatus(oldLifeCycleStatus.get()).build();
                    return itemLifeCycleUpdateResponse;
                }).switchIfEmpty(Mono.defer(()->Mono.error(
                        new WorkflowProgressException(HttpStatus.BAD_REQUEST,"Item workflow not found"))));
    }
}
