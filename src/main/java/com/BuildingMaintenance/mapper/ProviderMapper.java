package com.BuildingMaintenance.mapper;

import com.BuildingMaintenance.controller.request.ProviderRequest;
import com.BuildingMaintenance.controller.response.ProviderResponse;
import com.BuildingMaintenance.entity.Provider;
import lombok.experimental.UtilityClass;

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
}
