package com.health_insurance.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.health_insurance.backend.repository.StatusRepository;
import com.health_insurance.backend.model.Status;
import com.health_insurance.backend.dto.StatusDto;

import java.util.List;

@RestController
@RequestMapping("/")
public class StatusController {

    @Autowired
    private StatusRepository statusRepository;

    @GetMapping("/list-status")
    public ResponseEntity<StatusDto> getAllStatus() {
        List<Status> status = statusRepository.findAll();
        StatusDto statusDto = new StatusDto(status);
        return new ResponseEntity<>(statusDto, HttpStatus.OK);
    }
}
