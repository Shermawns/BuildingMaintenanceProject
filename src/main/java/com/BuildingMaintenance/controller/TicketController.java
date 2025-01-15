package com.BuildingMaintenance.controller;
import com.BuildingMaintenance.controller.request.TicketRequest;
import com.BuildingMaintenance.controller.request.TicketTriRequest;
import com.BuildingMaintenance.controller.response.TicketResponse;
import com.BuildingMaintenance.mapper.*;
import com.BuildingMaintenance.entity.Ticket;
import com.BuildingMaintenance.repository.StoreRepository;
import com.BuildingMaintenance.service.TicketService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/tickets")
public class TicketController {

    private final TicketService ticketService;

    private final StoreRepository storeRepository;

    public TicketController(TicketService ticketService, StoreRepository storeRepository) {
        this.ticketService = ticketService;
        this.storeRepository = storeRepository;
    }


    @GetMapping
    public ResponseEntity<List<TicketResponse>> findAll(){
        List<Ticket> tickets = ticketService.findAll();
        return ResponseEntity.ok().body(TicketMapper.toTicketResponse(tickets));
    }

    @GetMapping(value = "store/{storeUsername}")
    public ResponseEntity<List<TicketResponse>> findByUsername(@PathVariable String storeUsername) {
        List<Ticket> tickets = ticketService.findByStoreUsername(storeUsername);
        return ResponseEntity.ok().body(TicketMapper.toTicketResponse(tickets));
    }

    @GetMapping(value = "trilogger/{TriUsername}")
    public ResponseEntity<List<TicketResponse>> findByTriUsername(@PathVariable String triUsername){
        List<Ticket> tickets = ticketService.findByTriUsername(triUsername);
        return ResponseEntity.ok().body(TicketMapper.toTicketResponse(tickets));
    }


    @PostMapping(value = "/create")
    public ResponseEntity<TicketResponse> createTicket(@RequestBody @Validated TicketRequest ticketRequest, @PathVariable Long id) {

        TicketResponse response = ticketService.create(ticketRequest, id);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }


    @PutMapping(value = "/edit/operations")
    public ResponseEntity<TicketResponse> createTriTicket(@RequestBody @Validated TicketTriRequest ticketTriRequest) {
        TicketResponse ticketResponse = ticketService.ticketByTrilogger(ticketTriRequest);

        return ResponseEntity.status(HttpStatus.OK).body(ticketResponse);
    }



}

