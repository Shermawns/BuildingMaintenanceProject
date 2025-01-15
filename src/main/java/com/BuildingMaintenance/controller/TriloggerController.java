package com.BuildingMaintenance.controller;

import com.BuildingMaintenance.controller.request.TriloggerRequest;
import com.BuildingMaintenance.controller.response.TriloggerResponse;
import com.BuildingMaintenance.entity.Trilogger;
import com.BuildingMaintenance.mapper.TriloggerMapper;
import com.BuildingMaintenance.service.TriloggerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/trilogger")
public class TriloggerController {

    private final TriloggerService triloggerService;


    public TriloggerController(TriloggerService triloggerService) {
        this.triloggerService = triloggerService;
    }

    @PostMapping(value = "/create")
    public ResponseEntity<TriloggerResponse> create (@RequestBody TriloggerRequest triloggerRequest){

        Trilogger trilogger = triloggerService.create(TriloggerMapper.toTrilogger(triloggerRequest));

        return ResponseEntity.status(HttpStatus.CREATED).body(TriloggerMapper.toTriloggerResponse(trilogger));
    }
}
