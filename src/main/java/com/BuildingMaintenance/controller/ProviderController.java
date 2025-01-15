package com.BuildingMaintenance.controller;

import com.BuildingMaintenance.controller.request.ProviderRequest;
import com.BuildingMaintenance.controller.response.ProviderResponse;
import com.BuildingMaintenance.entity.Provider;
import com.BuildingMaintenance.mapper.ProviderMapper;
import com.BuildingMaintenance.service.ProviderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/provider")
public class ProviderController {

    private final ProviderService providerService;

    public ProviderController(ProviderService providerService) {
        this.providerService = providerService;
    }

    @PostMapping(value = "/create")
    public ResponseEntity<ProviderResponse> create(@RequestBody ProviderRequest providerRequest){

        Provider provider = providerService.create(ProviderMapper.toProvider(providerRequest));

        return ResponseEntity.status(HttpStatus.CREATED).body(ProviderMapper.toProviderResponse(provider));
    }
}
