package com.seasolutions.desafio.controllers;

import com.seasolutions.desafio.domain.employee.Employee;
import com.seasolutions.desafio.domain.employee.EmployeeDTO;
import com.seasolutions.desafio.domain.employee.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeRepository repository;
    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees(){
        var allEmployees = repository.findAll();
      return ResponseEntity.ok(allEmployees);
    };

    @PostMapping
    public ResponseEntity<Employee> registerEmployee(@RequestBody EmployeeDTO data) {
        System.out.println(data.toObject());
        Employee newEmployee = data.toObject();
        repository.save(newEmployee);
        return ResponseEntity.ok().build();
    }
}

