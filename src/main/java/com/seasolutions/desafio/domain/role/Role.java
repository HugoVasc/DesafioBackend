package com.seasolutions.desafio.domain.role;

import com.seasolutions.desafio.domain.employee.Employee;
import com.seasolutions.desafio.domain.sector.Sector;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Table(name = "Role")
@Entity(name = "Role")
@Getter
@Setter
public class Role {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name", length = 150, nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "sector_name", referencedColumnName = "name")
    private Sector sector_name;


    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL)
    private List<Employee> employees;

    public Role(String name, Sector sector_name){
        this.name = name;
        this.sector_name = sector_name;
    }
}
