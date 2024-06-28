package com.health_insurance.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.health_insurance.backend.repository.CoverPlanRepository;
import com.health_insurance.backend.repository.DependentRepository;
import com.health_insurance.backend.dto.AddCoverPlanDto;
import com.health_insurance.backend.dto.DependentDto;
import com.health_insurance.backend.model.Dependent;
import com.health_insurance.backend.model.CoverPlan;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class DependentController {
    
    @Autowired
    private DependentRepository dependentRepository;

    @Autowired
    private CoverPlanRepository coverPlanRepository;

    @GetMapping("/list-dependents")
    public ResponseEntity<DependentDto> getAllDependents() {
        List<Dependent> dependents = dependentRepository.findAll();
        DependentDto dependentDto = new DependentDto(dependents);
        return new ResponseEntity<>(dependentDto, HttpStatus.OK);
    }

    @PostMapping("/add-dependent")
    public ResponseEntity<List<AddCoverPlanDto>> addDependent(@RequestBody List<Map<String, Object>> request) {
        List<AddCoverPlanDto> responseList = new ArrayList<>();

        try {
            for (Map<String, Object> dependentData: request) {
                try {
                    String dependentIDStr = (String) dependentData.get("childID");
                    Long dependentID = Long.valueOf(dependentIDStr);

                    String parentIDStr = (String) dependentData.get("parentID");
                    Long parentID = Long.valueOf(parentIDStr);

                    Optional<CoverPlan> parentPlanOptional = coverPlanRepository.findByPersonaID(parentID);
                    if (!parentPlanOptional.isPresent()) {
                        responseList.add(new AddCoverPlanDto("unsuccessful"));
                        continue;
                    }

                    CoverPlan parentPlan = parentPlanOptional.get();

                    Dependent dependent = new Dependent();
                    dependent.setPersonaID(dependentID);
                    dependent.setCoverPlan(parentPlan);

                    dependentRepository.save(dependent);

                    responseList.add(new AddCoverPlanDto("successful"));
                } catch (Exception e) {
                    e.printStackTrace();

                    responseList.add(new AddCoverPlanDto("unsuccessful"));
                }
            }
            return new ResponseEntity<>(responseList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
