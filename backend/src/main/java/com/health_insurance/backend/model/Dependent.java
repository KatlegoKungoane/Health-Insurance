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
@Table(name = "Dependent")
public class Dependent {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dependentID;

    @ManyToOne
    @JoinColumn(name = "coverPlanID", nullable = false)
    private CoverPlan coverPlan;

    @Column(name = "personaID", nullable = false)
    private Long personaID;
}
