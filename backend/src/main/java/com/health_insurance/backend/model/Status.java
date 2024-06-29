package com.health_insurance.backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Status", uniqueConstraints = @UniqueConstraint(name = "uq_status_name", columnNames = "name"))
public class Status {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long statusID;

    @Column(name = "name", nullable = false, length = 10)
    private String name;
}
