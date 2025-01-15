package com.BuildingMaintenance.service;

import com.BuildingMaintenance.entity.Provider;
import com.BuildingMaintenance.entity.enums.Role;
import com.BuildingMaintenance.repository.ProviderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProviderService {

    private final ProviderRepository providerRepository;

    public ProviderService(ProviderRepository providerRepository) {
        this.providerRepository = providerRepository;
    }

    public Provider create(Provider provider){
        provider.setRole(Role.ROLE_PROVIDER);
        return providerRepository.save(provider);
    }

    public List<Provider> findAll(){
        return providerRepository.findAll();
    }

    public void delete(Long id){
        providerRepository.deleteById(id);
    }

    public Provider updateProvider(Long id, Provider provider){
        Provider existingProvider = providerRepository.findById(id).
                orElseThrow(()-> new RuntimeException("Provider with id " + id + "is not exist"));

        if (existingProvider.getEmail() != null) {
            existingProvider.setEmail(provider.getEmail());
        }
        if (existingProvider.getEmail() != null) {
            existingProvider.setPassword(provider.getPassword());
        }
        if (existingProvider.getCnpj() != null) {
            existingProvider.setCnpj(provider.getCnpj());
        }

        return providerRepository.save(existingProvider);
    }

}
