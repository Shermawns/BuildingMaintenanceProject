package com.BuildingMaintenance.mapper;

import com.BuildingMaintenance.controller.request.StoreRequest;
import com.BuildingMaintenance.controller.response.StoreResponse;
import com.BuildingMaintenance.controller.response.TriloggerResponse;
import com.BuildingMaintenance.entity.Store;
import com.BuildingMaintenance.entity.Trilogger;
import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.stream.Collectors;

@UtilityClass
public class StoreMapper {


    public static Store toStore(StoreRequest requestStoreDTO){
        Store store = new Store();
        store.setEmail(requestStoreDTO.email());
        store.setPassword(requestStoreDTO.password());
        store.setCnpj(requestStoreDTO.cnpj());
        store.setCreatedDate(requestStoreDTO.createdDate());

        return store;
    }


    public static StoreResponse toStoreResponse(Store store){

        return new StoreResponse(store.getId(), store.getEmail(), store.getCnpj(), store.getCreatedDate());

    }

    public static List<StoreResponse> toListStore(List<Store> stores){
        return stores.stream()
                .map(store -> new StoreResponse(
                        store.getId(),
                        store.getEmail(),
                        store.getCnpj(),
                        store.getCreatedDate()
                ))
                .collect(Collectors.toList());
    }
}
