package com.seasolutions.desafio.domain.employee;

import com.seasolutions.desafio.domain.role.Role;
import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.AccessLevel;

@Getter
public class EmployeeDTO {
    private String cpf;
    private String name;
    private Role role;

    public Employee toObject(){
        return new Employee(cpf, name, role);
    }
}
