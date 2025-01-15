package com.BuildingMaintenance.entity;

import com.BuildingMaintenance.entity.enums.BuildingType;
import com.BuildingMaintenance.entity.enums.RolePriority;
import com.BuildingMaintenance.entity.enums.TicketStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "ticketId")
@Entity
@Table(name = "tb_ticket")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ticket_id")
    private Long ticketId;

    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;

    @ManyToOne
    @JoinColumn(name = "trilogger_id")
    private Trilogger trilogger;

    @ManyToOne
    @JoinColumn(name = "provider_id")
    private Provider provider;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(nullable = false, length = 200)
    private String description;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private BuildingType service;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TicketStatus status = TicketStatus.OPEN;

    @Enumerated(EnumType.STRING)
    private RolePriority priority = RolePriority.LOW;

    @Column(name = "created_date")
    private LocalDate createdDate = LocalDate.now();

    @PrePersist
    protected void onCreate() {
        this.createdDate = LocalDate.now();
    }

    private LocalDate deadline;

    public Long getTicketId() {
        return ticketId;
    }

    public void setTicketId(Long ticketId) {
        this.ticketId = ticketId;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Trilogger getTrilogger() {
        return trilogger;
    }

    public void setTrilogger(Trilogger trilogger) {
        this.trilogger = trilogger;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BuildingType getService() {
        return service;
    }

    public void setService(BuildingType service) {
        this.service = service;
    }

    public TicketStatus getStatus() {
        return status;
    }

    public void setStatus(TicketStatus status) {
        this.status = status;
    }

    public RolePriority getPriority() {
        return priority;
    }

    public void setPriority(RolePriority priority) {
        this.priority = priority;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }
}