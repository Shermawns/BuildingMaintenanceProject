package com.BuildingMaintenance.controller;

import com.BuildingMaintenance.controller.request.ProviderRequest;
import com.BuildingMaintenance.controller.request.StoreRequest;
import com.BuildingMaintenance.controller.response.ProviderResponse;
import com.BuildingMaintenance.controller.response.StoreResponse;
import com.BuildingMaintenance.entity.Provider;
import com.BuildingMaintenance.entity.Store;
import com.BuildingMaintenance.mapper.ProviderMapper;
import com.BuildingMaintenance.mapper.StoreMapper;
import com.BuildingMaintenance.service.StoreService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/store")
public class StoreController {

    private final StoreService storeService;

    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    @PostMapping(value = "/create")
    public ResponseEntity<StoreResponse> create(@RequestBody StoreRequest storeRequest){

        Store result = storeService.create(StoreMapper.toStore(storeRequest));

        return ResponseEntity.status(HttpStatus.CREATED).body(StoreMapper.toStoreResponse(result));
    }

    @GetMapping
    public ResponseEntity<List<StoreResponse>> findAll(){

        List<Store> list = storeService.findAll();

        return ResponseEntity.ok().body(StoreMapper.toListStore(list));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){

        storeService.delete(id);

        return ResponseEntity.status(HttpStatus.OK).body("Store deleted successfully");
    }

    @PutMapping(value = "/edit/{id}")
    public ResponseEntity<StoreResponse> edit(@RequestBody StoreRequest storeRequest, @PathVariable Long id){

        Store editStore = storeService.updateStore(id, StoreMapper.toStore(storeRequest));

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(StoreMapper.toStoreResponse(editStore));
    }

}
