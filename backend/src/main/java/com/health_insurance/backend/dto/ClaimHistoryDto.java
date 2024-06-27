package com.health_insurance.backend.dto;

import java.util.List;

import com.health_insurance.backend.model.ClaimHistory;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClaimHistoryDto {
    
    private List<ClaimHistory> claimHistories;
}
