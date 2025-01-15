package com.BuildingMaintenance.controller.request;

import com.BuildingMaintenance.entity.enums.BuildingType;

public record TicketRequest(Long storeId,
                            String title,
                            String description,
                            BuildingType service) {
}
