package com.BuildingMaintenance.mapper;

import com.BuildingMaintenance.controller.request.TicketRequest;
import com.BuildingMaintenance.controller.response.TicketResponse;
import com.BuildingMaintenance.entity.Ticket;
import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.stream.Collectors;

@UtilityClass
public class TicketMapper {

    public static List<TicketResponse> toTicketResponseList(List<Ticket> tickets) {
        return tickets.stream()
                .map(ticket -> new TicketResponse(
                        ticket.getTicketId(),
                        ticket.getStore(),
                        ticket.getTrilogger(),
                        ticket.getProvider(),
                        ticket.getTitle(),
                        ticket.getDescription(),
                        ticket.getService(),
                        ticket.getStatus(),
                        ticket.getPriority(),
                        ticket.getCreatedDate(),
                        ticket.getDeadline()
                ))
                .collect(Collectors.toList());
    }

    public static TicketResponse toTicketResponse(Ticket ticket) {
        return new TicketResponse(
                ticket.getTicketId(),
                ticket.getStore(),
                ticket.getTrilogger(),
                ticket.getProvider(),
                ticket.getTitle(),
                ticket.getDescription(),
                ticket.getService(),
                ticket.getStatus(),
                ticket.getPriority(),
                ticket.getCreatedDate(),
                ticket.getDeadline()
        );
    }

}
