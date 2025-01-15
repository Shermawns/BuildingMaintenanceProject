package com.BuildingMaintenance.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "tb_provider")
public class Provider extends User {

    @Column(unique = true, nullable = false, length = 100)
    private String cnpj;

    @OneToMany(mappedBy = "provider")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Ticket> tickets = new ArrayList<>();

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

}