package com.seasolutions.desafio.controllers;

import com.seasolutions.desafio.domain.employee.Employee;
import com.seasolutions.desafio.domain.employee.EmployeeDTO;
import com.seasolutions.desafio.domain.employee.EmployeeRepository;
import com.seasolutions.desafio.domain.sector.Sector;
import com.seasolutions.desafio.domain.sector.SectorDTO;
import com.seasolutions.desafio.domain.sector.SectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sector")
public class SectorController {

    @Autowired
    private SectorRepository repository;
    @GetMapping
    public ResponseEntity<List<Sector>> getAllSectors(){
        var allSectors = repository.findAll();
        return ResponseEntity.ok(allSectors);
    };

    @PostMapping
    public ResponseEntity<Sector> createSector(@RequestBody SectorDTO data) {
        System.out.println(data.toObject());
        Sector newSector = data.toObject();
        repository.save(newSector);
        return ResponseEntity.ok().build();
    }
}
