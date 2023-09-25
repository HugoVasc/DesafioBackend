package com.seasolutions.desafio.domain.employee;
import com.seasolutions.desafio.domain.role.Role;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Table(name = "Employee")
@Entity(name = "Employee")
@Getter
@Setter
@NoArgsConstructor
public class Employee {
    @Id
    @Column(name = "cpf")
    private String cpf;

    @Column(name = "name", length = 150, nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    private Role role;

    public Employee(String cpf, String name, Role role){
        this.role = role;
        this.cpf = cpf;
        this.name = name;
    };
}
