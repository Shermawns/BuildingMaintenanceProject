package com.BuildingMaintenance.mapper;

import com.BuildingMaintenance.controller.request.StoreRequest;
import com.BuildingMaintenance.controller.response.StoreResponse;
import com.BuildingMaintenance.entity.Store;
import lombok.experimental.UtilityClass;

@UtilityClass
public class StoreMapper {


    public static Store toRequestStoreDTO(StoreRequest requestStoreDTO){
        Store store = new Store();
        store.setEmail(requestStoreDTO.email());
        store.setPassword(requestStoreDTO.password());
        store.setCnpj(requestStoreDTO.cnpj());
        store.setCreatedDate(requestStoreDTO.createdDate());

        return store;
    }


    public static StoreResponse toResponseStoreDTO(Store s){
        StoreResponse responseStoreDTO = new StoreResponse(s.getId(), s.getEmail(), s.getCnpj(), s.getCreatedDate());

        return responseStoreDTO;
    }
}
