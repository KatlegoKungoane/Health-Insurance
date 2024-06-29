package com.health_insurance.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.health_insurance.backend.repository.DependentRepository;
import com.health_insurance.backend.dto.DependentDto;
import com.health_insurance.backend.model.Dependent;

import java.util.List;

@RestController
@RequestMapping("/")
public class DependentController {
    
    @Autowired
    private DependentRepository dependentRepository;

    @GetMapping("/list-dependents")
    public ResponseEntity<DependentDto> getAllDependents() {
        List<Dependent> dependents = dependentRepository.findAll();
        DependentDto dependentDto = new DependentDto(dependents);
        return new ResponseEntity<>(dependentDto, HttpStatus.OK);
    }
}
