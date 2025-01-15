package com.BuildingMaintenance.mapper;

import com.BuildingMaintenance.controller.request.StoreRequest;
import com.BuildingMaintenance.controller.response.StoreResponse;
import com.BuildingMaintenance.entity.Store;
import lombok.experimental.UtilityClass;

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
}
