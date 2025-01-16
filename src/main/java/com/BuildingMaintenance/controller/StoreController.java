package com.BuildingMaintenance.controller;

import com.BuildingMaintenance.controller.request.StoreRequest;
import com.BuildingMaintenance.controller.response.StoreResponse;
import com.BuildingMaintenance.entity.Store;
import com.BuildingMaintenance.mapper.StoreMapper;
import com.BuildingMaintenance.service.StoreService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/store")
public class StoreController {

    private final StoreService storeService;

    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    @Operation(summary = "Create a new store", description = "Creates a new store using the provided request body.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Store created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid request body")
    })
    @PostMapping(value = "/create")
    public ResponseEntity<StoreResponse> create(@Validated @RequestBody StoreRequest storeRequest) {
        Store result = storeService.create(StoreMapper.toStore(storeRequest));
        return ResponseEntity.status(HttpStatus.CREATED).body(StoreMapper.toStoreResponse(result));
    }

    @Operation(summary = "List all stores", description = "Retrieves a list of all registered stores.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List retrieved successfully")
    })
    @GetMapping
    public ResponseEntity<List<StoreResponse>> findAll() {
        List<Store> list = storeService.findAll();
        return ResponseEntity.ok().body(StoreMapper.toListStore(list));
    }

    @Operation(summary = "Delete a store", description = "Deletes a store based on the given ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Store deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Store not found")
    })
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        storeService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Store deleted successfully");
    }

    @Operation(summary = "Edit a store", description = "Updates a store's details based on the given ID and request body.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "202", description = "Store updated successfully"),
            @ApiResponse(responseCode = "404", description = "Store not found")
    })
    @PutMapping(value = "/edit/{id}")
    public ResponseEntity<StoreResponse> edit(@Validated @RequestBody StoreRequest storeRequest, @PathVariable Long id) {
        Store editStore = storeService.updateStore(id, StoreMapper.toStore(storeRequest));
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(StoreMapper.toStoreResponse(editStore));
    }
}
