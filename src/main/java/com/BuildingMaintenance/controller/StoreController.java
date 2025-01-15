package com.BuildingMaintenance.controller;

import com.BuildingMaintenance.controller.request.StoreRequest;
import com.BuildingMaintenance.controller.response.StoreResponse;
import com.BuildingMaintenance.entity.Store;
import com.BuildingMaintenance.mapper.StoreMapper;
import com.BuildingMaintenance.service.StoreService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/store")
public class StoreController {

    private final StoreService storeService;

    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    @PostMapping(value = "/create")
    public ResponseEntity<StoreResponse> create(@RequestBody StoreRequest storeRequest){
        Store store = StoreMapper.toRequestStoreDTO(storeRequest);

        Store result = storeService.create(store);

        StoreResponse storeResponse = StoreMapper.toResponseStoreDTO(result);

        return ResponseEntity.status(HttpStatus.CREATED).body(storeResponse);
    }
}
