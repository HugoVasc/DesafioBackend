package com.seasolutions.desafio.domain.role;

import com.seasolutions.desafio.domain.employee.Employee;
import com.seasolutions.desafio.domain.sector.Sector;
import com.seasolutions.desafio.domain.sector.SectorRepository;
import lombok.Getter;

import java.util.List;

@Getter
public class RoleDTO {
    private String name;
    private Sector sector_name;
//    private List<Employee> employees;

    public String getName(){
        return name;
    }
    public String getSectorName() {
        return sector_name.toString();
    }
    public Role toObject() {
        return new Role(name, sector_name);
    }
}
