package com.BuildingMaintenance.controller;

import com.BuildingMaintenance.controller.request.ProviderRequest;
import com.BuildingMaintenance.controller.response.ProviderResponse;
import com.BuildingMaintenance.entity.Provider;
import com.BuildingMaintenance.mapper.ProviderMapper;
import com.BuildingMaintenance.service.ProviderService;
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

    @PostMapping(value = "/create")
    public ResponseEntity<ProviderResponse> create(@Validated @RequestBody ProviderRequest providerRequest){

        Provider provider = providerService.create(ProviderMapper.toProvider(providerRequest));

        return ResponseEntity.status(HttpStatus.CREATED).body(ProviderMapper.toProviderResponse(provider));
    }

    @GetMapping
    public ResponseEntity<List<ProviderResponse>> findAll(){

        List<Provider> list = providerService.findAll();

        return ResponseEntity.ok().body(ProviderMapper.toListProvider(list));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){

        providerService.delete(id);

        return ResponseEntity.status(HttpStatus.OK).body("Provider deleted successfully");
    }


    @PutMapping(value = "/edit/{id}")
    public ResponseEntity<ProviderResponse> edit(@Validated @RequestBody ProviderRequest providerRequest, @PathVariable Long id){

        Provider editProvider = providerService.updateProvider(id, ProviderMapper.toProvider(providerRequest));

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(ProviderMapper.toProviderResponse(editProvider));
    }

}
