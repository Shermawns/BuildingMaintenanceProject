package com.BuildingMaintenance.controller;

import com.BuildingMaintenance.controller.request.TriloggerRequest;
import com.BuildingMaintenance.controller.response.TriloggerResponse;
import com.BuildingMaintenance.entity.Trilogger;
import com.BuildingMaintenance.mapper.TriloggerMapper;
import com.BuildingMaintenance.service.TriloggerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public ResponseEntity<List<TriloggerResponse>> findAll(){

        List<Trilogger> list = triloggerService.findAll();

        return ResponseEntity.ok().body(TriloggerMapper.toListTriloggers(list));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){

         triloggerService.delete(id);

        return ResponseEntity.status(HttpStatus.OK).body("Trilogger deleted successfully");
    }

    @PutMapping(value = "/edit/{id}")
    public ResponseEntity<TriloggerResponse> edit(@RequestBody TriloggerRequest triloggerRequest, @PathVariable Long id){

        Trilogger editTrilogger = triloggerService.updateTrilogger(id, TriloggerMapper.toTrilogger(triloggerRequest));

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(TriloggerMapper.toTriloggerResponse(editTrilogger));
    }

}
