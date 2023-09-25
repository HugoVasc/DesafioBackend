package com.seasolutions.desafio.domain.sector;

import com.seasolutions.desafio.domain.role.Role;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Table(name = "Sector")
@Entity(name = "Sector")
@Getter
@Setter
@NoArgsConstructor
//@EqualsAndHashCode(of = "id")
public class Sector {
    @Id
    @Column(name = "name", length = 150)
    private String name;

//    @OneToMany(targetEntity = Role.class, cascade = CascadeType.ALL)
//    @JoinColumn(name = "FK_Sector", referencedColumnName = "name")
    @OneToMany(mappedBy = "sector_name", cascade = CascadeType.ALL)
    private List<Role> roles;

    public Sector(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
