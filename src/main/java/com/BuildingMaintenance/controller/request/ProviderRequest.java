package com.BuildingMaintenance.controller.request;

public record ProviderRequest(String email,
                              String password,
                              String cnpj) {
}
