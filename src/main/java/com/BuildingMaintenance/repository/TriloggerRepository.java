package com.BuildingMaintenance.repository;

import com.BuildingMaintenance.entity.Trilogger;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TriloggerRepository extends JpaRepository<Trilogger,Long> {
    Optional<Trilogger> findByEmail(String username);
}
