package com.BuildingMaintenance.controller;
import com.BuildingMaintenance.controller.request.TicketRequest;
import com.BuildingMaintenance.controller.request.TicketTriRequest;
import com.BuildingMaintenance.controller.response.TicketResponse;
import com.BuildingMaintenance.mapper.*;
import com.BuildingMaintenance.entity.Ticket;
import com.BuildingMaintenance.repository.StoreRepository;
import com.BuildingMaintenance.service.TicketService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/tickets")
public class TicketController {

    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @Operation(summary = "List all tickets", description = "Retrieves a list of all tickets.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List retrieved successfully")
    })
    @GetMapping
    public ResponseEntity<List<TicketResponse>> findAll() {
        List<Ticket> tickets = ticketService.findAll();
        return ResponseEntity.ok().body(TicketMapper.toTicketResponseList(tickets));
    }

    @Operation(summary = "List tickets by store username", description = "Retrieves tickets associated with a specific store username.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List retrieved successfully"),
            @ApiResponse(responseCode = "404", description = "Store not found")
    })
    @GetMapping(value = "store/{storeUsername}")
    public ResponseEntity<List<TicketResponse>> findByUsername(@PathVariable String storeUsername) {
        List<Ticket> tickets = ticketService.findByStoreUsername(storeUsername);
        return ResponseEntity.ok().body(TicketMapper.toTicketResponseList(tickets));
    }

    @Operation(summary = "List tickets by trilogger username", description = "Retrieves tickets associated with a specific trilogger username.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List retrieved successfully"),
            @ApiResponse(responseCode = "404", description = "Trilogger not found")
    })
    @GetMapping(value = "trilogger/{triUsername}")
    public ResponseEntity<List<TicketResponse>> findByTriUsername(@PathVariable String triUsername) {
        List<Ticket> tickets = ticketService.findByTriUsername(triUsername);
        return ResponseEntity.ok().body(TicketMapper.toTicketResponseList(tickets));
    }

    @Operation(summary = "Create a new ticket", description = "Creates a new ticket using the provided request body.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Ticket created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid request body")
    })
    @PostMapping(value = "/create")
    public ResponseEntity<TicketResponse> createTicket(@RequestBody TicketRequest ticketRequest) {
        Ticket ticket = ticketService.create(ticketRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(TicketMapper.toTicketResponse(ticket));
    }

    @Operation(summary = "Edit ticket operations", description = "Updates a ticket's details using trilogger operations.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ticket updated successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid request body"),
            @ApiResponse(responseCode = "404", description = "Ticket not found")
    })
    @PutMapping(value = "/edit/operations")
    public ResponseEntity<TicketResponse> createTriTicket(@Validated @RequestBody TicketTriRequest ticketTriRequest) {
        Ticket updateTicket = ticketService.ticketByTrilogger(ticketTriRequest);
        return ResponseEntity.status(HttpStatus.OK).body(TicketMapper.toTicketResponse(updateTicket));
    }
}


