package com.BuildingMaintenance.service;

import com.BuildingMaintenance.entity.Trilogger;
import com.BuildingMaintenance.entity.enums.Role;
import com.BuildingMaintenance.repository.TriloggerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TriloggerService {

    private final TriloggerRepository triloggerRepository;

    public TriloggerService(TriloggerRepository triloggerRepository) {
        this.triloggerRepository = triloggerRepository;
    }

    public Trilogger create(Trilogger trilogger) {
        trilogger.setRole(Role.ROLE_TRILOGGER);
        return triloggerRepository.save(trilogger);
    }

    public List<Trilogger> findAll() {
        return triloggerRepository.findAll();
    }

    public void delete(Long id) {
        triloggerRepository.deleteById(id);
    }

    public Trilogger updateTrilogger(Long id, Trilogger trilogger) {
        Trilogger existingTrilogger = triloggerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Trilogger with id " + id + " does not exist"));

        if (trilogger.getEmail() != null) {
            existingTrilogger.setEmail(trilogger.getEmail());
        }
        if (trilogger.getPassword() != null) {
            existingTrilogger.setPassword(trilogger.getPassword());
        }

        return triloggerRepository.save(existingTrilogger);
    }
}
