package com.BuildingMaintenance.controller.response;

import java.time.LocalDate;

public record ProviderResponse(Long id,
                               String email,
                               String cnpj,
                               LocalDate createdDate) {
}
