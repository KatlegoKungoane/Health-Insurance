package com.health_insurance.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.health_insurance.backend.repository.ClaimHistoryRepository;
import com.health_insurance.backend.dto.ClaimHistoryDto;
import com.health_insurance.backend.model.ClaimHistory;

import java.util.List;

@RestController
@RequestMapping("/")
public class ClaimHistoryController {
    
    @Autowired
    private ClaimHistoryRepository claimHistoryRepository;

    @GetMapping("/list-claimhistory")
    public ResponseEntity<ClaimHistoryDto> getAllClaimHistories() {
        List<ClaimHistory> claimHistories = claimHistoryRepository.findAll();
        ClaimHistoryDto claimHistoryDto = new ClaimHistoryDto(claimHistories);
        return new ResponseEntity<>(claimHistoryDto, HttpStatus.OK);
    }
}
