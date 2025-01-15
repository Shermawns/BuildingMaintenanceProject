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

    public Ticket create(TicketRequest requestTicketDTO) {
        Store store = storeRepository.findById(requestTicketDTO.storeId())
                .orElseThrow(() -> new RuntimeException("Store not found with ID: " + requestTicketDTO.storeId()));

        Ticket ticket = new Ticket();
        ticket.setStore(store);
        ticket.setTitle(requestTicketDTO.title());
        ticket.setDescription(requestTicketDTO.description());
        ticket.setService(requestTicketDTO.service());

        return ticketRepository.save(ticket);
    }




    public Ticket ticketByTrilogger(TicketTriRequest ticketTriRequest) {
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

        return ticketRepository.save(updatedTicket);
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
