package com.BuildingMaintenance.service;

import com.BuildingMaintenance.controller.request.TicketRequest;
import com.BuildingMaintenance.controller.request.TicketTriRequest;
import com.BuildingMaintenance.controller.response.TicketResponse;
import com.BuildingMaintenance.entity.Provider;
import com.BuildingMaintenance.entity.Store;
import com.BuildingMaintenance.entity.Ticket;
import com.BuildingMaintenance.entity.Trilogger;
import com.BuildingMaintenance.entity.enums.RolePriority;
import com.BuildingMaintenance.entity.enums.TicketStatus;
import com.BuildingMaintenance.repository.ProviderRepository;
import com.BuildingMaintenance.repository.StoreRepository;
import com.BuildingMaintenance.repository.TicketRepository;
import com.BuildingMaintenance.repository.TriloggerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;
    private final StoreRepository storeRepository;
    private final TriloggerRepository triloggerRepository;
    private final ProviderRepository providerRepository;

    public TicketService(TicketRepository ticketRepository,
                         StoreRepository storeRepository,
                         TriloggerRepository triloggerRepository,
                         ProviderRepository providerRepository) {
        this.ticketRepository = ticketRepository;
        this.storeRepository = storeRepository;
        this.triloggerRepository = triloggerRepository;
        this.providerRepository = providerRepository;
    }

    public List<Ticket> findAll() {
        return ticketRepository.findAll();
    }

    public List<Ticket> findByStoreUsername(String username) {
        return ticketRepository.findByStoreEmail(username);
    }

    public List<Ticket> findByTriUsername(String username) {
        return ticketRepository.findByTriloggerEmail(username);
    }

    public TicketResponse create(TicketRequest ticketRequest, Long id) {
        Store store = storeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Store not found with id: " + id));

        Ticket ticket = new Ticket();
        ticket.setStore(store);
        ticket.setTitle(ticketRequest.title());
        ticket.setDescription(ticketRequest.description());
        ticket.setService(ticketRequest.service());

        Ticket savedTicket = ticketRepository.save(ticket);

        return new TicketResponse(
                savedTicket.getTicketId(),
                savedTicket.getStore(),
                savedTicket.getTrilogger(),
                savedTicket.getProvider(),
                savedTicket.getTitle(),
                savedTicket.getDescription(),
                savedTicket.getService(),
                savedTicket.getStatus(),
                savedTicket.getPriority(),
                savedTicket.getCreatedDate(),
                savedTicket.getDeadline()
        );
    }




    public TicketResponse ticketByTrilogger(TicketTriRequest ticketTriRequest) {
        Ticket ticket = findTicketById(ticketTriRequest.ticketId());

        Trilogger trilogger = findTriloggerByUsername(ticketTriRequest.trilogger());
        Provider provider = findProviderByUsername(ticketTriRequest.provider());

        ticket.setTrilogger(trilogger);
        ticket.setProvider(provider);
        ticket.setDeadline(ticketTriRequest.deadline());
        ticket.setPriority(Optional.ofNullable(ticketTriRequest.priority()).orElse(RolePriority.LOW));
        ticket.setStatus(Optional.ofNullable(ticketTriRequest.status()).orElse(TicketStatus.OPEN));
        ticket.setService(ticketTriRequest.service());

        Ticket updatedTicket = ticketRepository.save(ticket);

        return new TicketResponse(
                updatedTicket.getTicketId(),
                updatedTicket.getStore(),
                updatedTicket.getTrilogger(),
                updatedTicket.getProvider(),
                updatedTicket.getTitle(),
                updatedTicket.getDescription(),
                updatedTicket.getService(),
                updatedTicket.getStatus(),
                updatedTicket.getPriority(),
                updatedTicket.getCreatedDate(),
                updatedTicket.getDeadline()
        );
    }


    private Store findStoreById(Long storeId) {
        return storeRepository.findById(storeId)
                .orElseThrow(() -> new RuntimeException("Store not found with ID: " + storeId));
    }

    private Ticket findTicketById(Long ticketId) {
        return ticketRepository.findById(ticketId)
                .orElseThrow(() -> new RuntimeException("Ticket not found with ID: " + ticketId));
    }

    private Trilogger findTriloggerByUsername(String username) {
        return triloggerRepository.findByEmail(username)
                .orElseThrow(() -> new RuntimeException("Trilogger not found with username: " + username));
    }

    private Provider findProviderByUsername(String username) {
        return providerRepository.findByEmail(username)
                .orElseThrow(() -> new RuntimeException("Provider not found with username: " + username));
    }
}
