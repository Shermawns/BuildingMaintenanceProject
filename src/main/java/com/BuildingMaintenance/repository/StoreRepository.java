package com.BuildingMaintenance.repository;

import com.BuildingMaintenance.entity.Store;
import com.BuildingMaintenance.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StoreRepository extends JpaRepository<Store, Long> {
    Optional<Ticket> findByEmail(String storeEmail);
}
