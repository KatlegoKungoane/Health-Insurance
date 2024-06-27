package com.health_insurance.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.health_insurance.backend.repository.CoverPlanRepository;
import com.health_insurance.backend.model.CoverPlan;
import com.health_insurance.backend.dto.CoverPlanDto;

import java.util.List;

@RestController
@RequestMapping("/")
public class CoverPlanController {
    
    @Autowired
    private CoverPlanRepository coverPlanRepository;

    @GetMapping("/list-coverplan")
    public ResponseEntity<CoverPlanDto> getAllCoverPlans() {
        List<CoverPlan> coverPlan = coverPlanRepository.findAll();
        CoverPlanDto coverPlanDto = new CoverPlanDto(coverPlan);
        return new ResponseEntity<>(coverPlanDto, HttpStatus.OK);
    }
}
