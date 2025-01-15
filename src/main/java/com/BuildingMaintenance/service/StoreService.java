package com.BuildingMaintenance.service;

import com.BuildingMaintenance.entity.Store;
import com.BuildingMaintenance.entity.User;
import com.BuildingMaintenance.entity.enums.Role;
import com.BuildingMaintenance.repository.StoreRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreService {

    private final StoreRepository storeRepository;

    public StoreService(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    public Store create(Store store) {
        store.setRole(Role.ROLE_STORE);
        return storeRepository.save(store);
    }

    public List<Store> findAll() {
        return storeRepository.findAll();
    }

    public void delete(Long id) {
        storeRepository.deleteById(id);
    }

    public Store updateStore(Long id, Store store) {
        Store existingStore = storeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Store with id " + id + " does not exist"));

        if (store.getEmail() != null) {
            existingStore.setEmail(store.getEmail());
        }
        if (store.getPassword() != null) {
            existingStore.setPassword(store.getPassword());
        }
        if (store.getCnpj() != null) {
            existingStore.setCnpj(store.getCnpj());
        }

        return storeRepository.save(existingStore);
    }
}
