package com.BuildingMaintenance.controller.request;

import jakarta.validation.constraints.*;

import java.time.LocalDate;

public record StoreRequest(@NotBlank @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$",
                                                message = "Email must be a valid format") String email,
                           @NotBlank  String password,
                           @NotNull
                           @Size(min = 14, message = "CNPJ must be at least 14 characters")String cnpj,
                           LocalDate createdDate) {
}
