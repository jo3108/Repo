package com.example.workflow_service.controller;

import com.example.workflow_service.constants.ItemLifeCycleStatus;
import com.example.workflow_service.model.ItemLifeCycleUpdateRequest;
import com.example.workflow_service.model.ItemLifeCycleUpdateResponse;
import com.example.workflow_service.model.ItemSave;
import com.example.workflow_service.service.ItemLifeCycleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/lifecycle")
public class ItemLifeCycleController {

    private final ItemLifeCycleService itemLifeCycleService;

    public ItemLifeCycleController(ItemLifeCycleService itemLifeCycleService){
        this.itemLifeCycleService = itemLifeCycleService;
    }

    @PostMapping("/save")
    public void saveItem(ItemSave itemSave){
        itemLifeCycleService.save(itemSave);
    }


    @PutMapping("/{itemid}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<ResponseEntity<ItemLifeCycleUpdateResponse>> update(@PathVariable String itemId, @RequestBody ItemLifeCycleUpdateRequest itemLifeCycleUpdateRequest){
        return itemLifeCycleService.update(itemId, ItemLifeCycleStatus.from(itemLifeCycleUpdateRequest.getItemLifeCycleStatus()))
                .map(itemLifeCycleUpdateResponse -> new ResponseEntity<>(itemLifeCycleUpdateResponse, HttpStatus.OK));
    }
}
