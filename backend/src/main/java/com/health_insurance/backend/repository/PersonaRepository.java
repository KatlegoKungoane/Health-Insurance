package com.health_insurance.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.health_insurance.backend.model.Persona;

public interface PersonaRepository extends JpaRepository<Persona, Long> {
}
