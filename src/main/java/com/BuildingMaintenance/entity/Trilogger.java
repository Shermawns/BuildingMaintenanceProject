package com.BuildingMaintenance.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "tb_trilogger")
public class Trilogger extends User {

    @OneToMany(mappedBy = "trilogger")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Ticket> tickets = new ArrayList<>();
}