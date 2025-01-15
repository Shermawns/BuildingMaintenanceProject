package com.BuildingMaintenance.repository;

import com.BuildingMaintenance.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
    List<Ticket> findByStoreEmail(String username);

    List<Ticket> findByTriloggerEmail(String username);
}
