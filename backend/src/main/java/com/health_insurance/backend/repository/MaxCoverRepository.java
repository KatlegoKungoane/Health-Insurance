package com.health_insurance.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.health_insurance.backend.model.MaxCover;

public interface MaxCoverRepository extends JpaRepository<MaxCover, Long> {
}
