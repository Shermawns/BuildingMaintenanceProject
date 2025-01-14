package com.BuildingMaintenance.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public abstract class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false, length = 50)
    private String email;

    @Column(nullable = false, length = 200)
    @JsonIgnore
    private String password;

    @Column(name = "created_date")
    private LocalDate createdDate = LocalDate.now();

    @PrePersist
    protected void onCreate() {
        this.createdDate = LocalDate.now();
    }
}