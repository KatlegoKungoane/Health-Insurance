package com.health_insurance.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.health_insurance.backend.repository.PersonaRepository;
import com.health_insurance.backend.dto.PersonaDto;
import com.health_insurance.backend.model.Persona;

import java.util.List;

@RestController
@RequestMapping("/")
public class PersonaController {
    
    @Autowired
    private PersonaRepository personaRepository;

    @GetMapping("/list-personas")
    public ResponseEntity<PersonaDto> getAllPersonas() {
        List<Persona> personas = personaRepository.findAll();
        PersonaDto personaDto = new PersonaDto(personas);
        return new ResponseEntity<>(personaDto, HttpStatus.OK);
    }
}
