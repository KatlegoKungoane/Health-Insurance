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
@Table(name = "CoverPlan")
public class CoverPlan {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long coverPlanID;

    @Column(name = "personaID", nullable = false)
    private Long personaID;

    @ManyToOne
    @JoinColumn(name = "statusID", nullable = false)
    private Status status;
}
