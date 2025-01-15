package com.BuildingMaintenance.controller.response;

import com.BuildingMaintenance.entity.Provider;
import com.BuildingMaintenance.entity.Store;
import com.BuildingMaintenance.entity.Trilogger;
import com.BuildingMaintenance.entity.enums.BuildingType;
import com.BuildingMaintenance.entity.enums.RolePriority;
import com.BuildingMaintenance.entity.enums.TicketStatus;

import java.time.LocalDate;

public record TicketResponse(Long ticketId,
                             Store store,
                             Trilogger trilogger,
                             Provider provider,
                             String title,
                             String description,
                             BuildingType service,
                             TicketStatus status,
                             RolePriority priority,
                             LocalDate createdDate,
                             LocalDate deadline) {
}
