package com.health_insurance.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.health_insurance.backend.repository.ClaimHistoryRepository;
import com.health_insurance.backend.repository.CoverPlanRepository;
import com.health_insurance.backend.repository.MaxCoverRepository;

import com.health_insurance.backend.dto.ClaimHistoryDto;

import com.health_insurance.backend.model.ClaimHistory;
import com.health_insurance.backend.model.CoverPlan;
import com.health_insurance.backend.model.MaxCover;
import com.health_insurance.backend.model.Status;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class ClaimHistoryController {

    @Autowired
    private ClaimHistoryRepository claimHistoryRepository;

    @Autowired
    private CoverPlanRepository coverPlanRepository;

    @Autowired
    private MaxCoverRepository maxCoverRepository;

    @GetMapping("/list-claimhistory")
    public ResponseEntity<ClaimHistoryDto> getAllClaimHistories() {
        List<ClaimHistory> claimHistories = claimHistoryRepository.findAll();
        ClaimHistoryDto claimHistoryDto = new ClaimHistoryDto(claimHistories);
        return new ResponseEntity<>(claimHistoryDto, HttpStatus.OK);
    }

    @PostMapping("/pay-claim")
    public ResponseEntity<ClaimHistoryDto> payClaim(@RequestBody List<Map<String, Object>> request) {

      for (Map<String, Object> personaData: request) {

        try {
            String personaIDStr = (String) personaData.get("personaID");
            Long personaID = Long.valueOf(personaIDStr);

            Optional<CoverPlan> coverPlanOptional = coverPlanRepository.findByPersonaID(personaID);
            if (!coverPlanOptional.isPresent()) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

            CoverPlan coverPlan = coverPlanOptional.get();
            Status coverPlanStatus = coverPlan.getStatus();
            if (coverPlanStatus == null || !"Active".equals(coverPlanStatus.getName())) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

            String claimAmountStr = (String) personaData.get("claimAmount");
            BigDecimal claimAmount =  new BigDecimal(claimAmountStr);

            MaxCover maxCover = maxCoverRepository.findByMaxCoverID(1L);
            BigDecimal maxCoverAmount = maxCover.getMaxCover();

            ClaimHistory claimHistory = new ClaimHistory();
            claimHistory.setCoverPlan(coverPlan);
            claimHistory.setClaimAmount(claimAmount);
            claimHistory.setClaimPersonaID(personaID);
            claimHistory.setTimeStamp(new Date());

            int result = claimAmount.compareTo(maxCoverAmount);
            if (result < 0) {
                claimHistory.setAmountPaid(maxCoverAmount);
            } else {
                claimHistory.setAmountPaid(claimAmount);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
      }

      return new ResponseEntity<>(HttpStatus.OK);
    }
}
