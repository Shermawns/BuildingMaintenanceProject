package com.BuildingMaintenance.controller.response;

import java.time.LocalDate;

public record TriloggerResponse(Long id,
                                String email,
                                LocalDate createdDate) {
}
