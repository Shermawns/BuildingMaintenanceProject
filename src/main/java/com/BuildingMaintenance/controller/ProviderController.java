package com.BuildingMaintenance.controller;

import com.BuildingMaintenance.controller.request.ProviderRequest;
import com.BuildingMaintenance.controller.response.ProviderResponse;
import com.BuildingMaintenance.entity.Provider;
import com.BuildingMaintenance.mapper.ProviderMapper;
import com.BuildingMaintenance.service.ProviderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(value = "/api/v1/provider")
public class ProviderController {

    private final ProviderService providerService;

    public ProviderController(ProviderService providerService) {
        this.providerService = providerService;
    }

    @Operation(summary = "Create a new provider", description = "Creates a new provider using the provided request body.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Provider created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid request body")
    })
    @PostMapping(value = "/create")
    public ResponseEntity<ProviderResponse> create(@Validated @RequestBody ProviderRequest providerRequest) {
        Provider provider = providerService.create(ProviderMapper.toProvider(providerRequest));
        return ResponseEntity.status(HttpStatus.CREATED).body(ProviderMapper.toProviderResponse(provider));
    }

    @Operation(summary = "List all providers", description = "Retrieves a list of all registered providers.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List retrieved successfully")
    })
    @GetMapping
    public ResponseEntity<List<ProviderResponse>> findAll() {
        List<Provider> list = providerService.findAll();
        return ResponseEntity.ok().body(ProviderMapper.toListProvider(list));
    }

    @Operation(summary = "Delete a provider", description = "Deletes a provider based on the given ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Provider deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Provider not found")
    })
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        providerService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Provider deleted successfully");
    }

    @Operation(summary = "Edit a provider", description = "Updates a provider's details based on the given ID and request body.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "202", description = "Provider updated successfully"),
            @ApiResponse(responseCode = "404", description = "Provider not found")
    })
    @PutMapping(value = "/edit/{id}")
    public ResponseEntity<ProviderResponse> edit(@Validated @RequestBody ProviderRequest providerRequest, @PathVariable Long id) {
        Provider editProvider = providerService.updateProvider(id, ProviderMapper.toProvider(providerRequest));
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(ProviderMapper.toProviderResponse(editProvider));
    }
}
