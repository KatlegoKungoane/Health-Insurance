package com.health_insurance.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.health_insurance.backend.model.Status;

public interface StatusRepository extends JpaRepository<Status, Long> {
}
