package com.BuildingMaintenance.controller;

import com.BuildingMaintenance.controller.request.TriloggerRequest;
import com.BuildingMaintenance.controller.response.TriloggerResponse;
import com.BuildingMaintenance.entity.Trilogger;
import com.BuildingMaintenance.mapper.TriloggerMapper;
import com.BuildingMaintenance.service.TriloggerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/trilogger")
public class TriloggerController {

    private final TriloggerService triloggerService;

    public TriloggerController(TriloggerService triloggerService) {
        this.triloggerService = triloggerService;
    }

    @Operation(summary = "Create a new trilogger", description = "Creates a new trilogger using the provided request body.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Trilogger created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid request body")
    })
    @PostMapping(value = "/create")
    public ResponseEntity<TriloggerResponse> create(@Validated @RequestBody TriloggerRequest triloggerRequest) {
        Trilogger trilogger = triloggerService.create(TriloggerMapper.toTrilogger(triloggerRequest));
        return ResponseEntity.status(HttpStatus.CREATED).body(TriloggerMapper.toTriloggerResponse(trilogger));
    }

    @Operation(summary = "List all triloggers", description = "Retrieves a list of all triloggers.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List retrieved successfully")
    })
    @GetMapping
    public ResponseEntity<List<TriloggerResponse>> findAll() {
        List<Trilogger> list = triloggerService.findAll();
        return ResponseEntity.ok().body(TriloggerMapper.toListTriloggers(list));
    }

    @Operation(summary = "Delete a trilogger", description = "Deletes a trilogger based on the given ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Trilogger deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Trilogger not found")
    })
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        triloggerService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Trilogger deleted successfully");
    }

    @Operation(summary = "Edit a trilogger", description = "Updates a trilogger's details based on the given ID and request body.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "202", description = "Trilogger updated successfully"),
            @ApiResponse(responseCode = "404", description = "Trilogger not found")
    })
    @PutMapping(value = "/edit/{id}")
    public ResponseEntity<TriloggerResponse> edit(@Validated @RequestBody TriloggerRequest triloggerRequest, @PathVariable Long id) {
        Trilogger editTrilogger = triloggerService.updateTrilogger(id, TriloggerMapper.toTrilogger(triloggerRequest));
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(TriloggerMapper.toTriloggerResponse(editTrilogger));
    }
}
