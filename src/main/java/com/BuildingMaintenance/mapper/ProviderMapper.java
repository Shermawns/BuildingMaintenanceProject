package com.BuildingMaintenance.mapper;

import com.BuildingMaintenance.controller.request.ProviderRequest;
import com.BuildingMaintenance.controller.response.ProviderResponse;
import com.BuildingMaintenance.controller.response.TriloggerResponse;
import com.BuildingMaintenance.entity.Provider;
import com.BuildingMaintenance.entity.Trilogger;
import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.stream.Collectors;

@UtilityClass
public class ProviderMapper {

    public static Provider toProvider(ProviderRequest providerRequest){
        Provider provider = new Provider();

        provider.setEmail(providerRequest.email());
        provider.setPassword(providerRequest.password());
        provider.setCnpj(providerRequest.cnpj());

        return provider;
    }

    public static ProviderResponse toProviderResponse(Provider provider){
        return new ProviderResponse(provider.getId(), provider.getEmail(), provider.getCnpj(), provider.getCreatedDate());
    }

    public static List<ProviderResponse> toListProvider(List<Provider> providers){
        return providers.stream()
                .map(provider -> new ProviderResponse(
                        provider.getId(),
                        provider.getEmail(),
                        provider.getCnpj(),
                        provider.getCreatedDate()
                ))
                .collect(Collectors.toList());
    }
}
