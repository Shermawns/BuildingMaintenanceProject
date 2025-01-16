package com.BuildingMaintenance.controller.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record TriloggerRequest(
        @NotBlank
        @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$",
                message = "Email must be a valid format")
        String email,

        @NotBlank(message = "Password cannot be blank")
        String password
) {
}
