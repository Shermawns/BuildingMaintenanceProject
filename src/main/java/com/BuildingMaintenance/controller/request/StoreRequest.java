package com.BuildingMaintenance.controller.request;

import java.time.LocalDate;

public record StoreRequest(String email,
                           String password,
                           String cnpj,
                           LocalDate createdDate) {
}
