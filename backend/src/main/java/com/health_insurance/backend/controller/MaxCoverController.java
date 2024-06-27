package com.health_insurance.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.health_insurance.backend.repository.MaxCoverRepository;
import com.health_insurance.backend.dto.MaxCoverDto;
import com.health_insurance.backend.model.MaxCover;

import java.util.List;

@RestController
@RequestMapping("/")
public class MaxCoverController {
    
    @Autowired
    private MaxCoverRepository maxCoverRepository;

    @GetMapping("/list-maxcover")
    public ResponseEntity<MaxCoverDto> getAllMaxCovers() {
        List<MaxCover> maxCover = maxCoverRepository.findAll();
        MaxCoverDto maxCoverDto = new MaxCoverDto(maxCover);
        return new ResponseEntity<>(maxCoverDto, HttpStatus.OK);
    }
}
