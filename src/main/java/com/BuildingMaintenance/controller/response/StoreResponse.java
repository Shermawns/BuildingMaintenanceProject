package com.BuildingMaintenance.controller.response;

import java.time.LocalDate;

public record StoreResponse(Long id,
                            String email,
                            String cnpj,
                            LocalDate createdDate) {


}
