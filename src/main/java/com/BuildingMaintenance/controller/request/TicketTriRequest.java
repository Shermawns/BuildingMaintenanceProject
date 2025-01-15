package com.BuildingMaintenance.controller.request;

import java.time.LocalDate;
import com.BuildingMaintenance.entity.enums.BuildingType;
import com.BuildingMaintenance.entity.enums.RolePriority;
import com.BuildingMaintenance.entity.enums.TicketStatus;

    public record TicketTriRequest(
        Long ticketId,
        String trilogger,
        String provider,
        LocalDate deadline,
        RolePriority priority,
        TicketStatus status,
        BuildingType service
) { }
