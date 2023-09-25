package com.seasolutions.desafio.controllers;
import com.seasolutions.desafio.domain.role.Role;
import com.seasolutions.desafio.domain.role.RoleDTO;
import com.seasolutions.desafio.domain.role.RoleRepository;
import com.seasolutions.desafio.domain.sector.Sector;
import com.seasolutions.desafio.domain.sector.SectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {
    private final RoleRepository roleRepository;
    private final SectorRepository sectorRepository;

    @Autowired
    public RoleController(RoleRepository roleRepository, SectorRepository sectorRepository) {
        this.roleRepository = roleRepository;
        this.sectorRepository = sectorRepository;
    }

    @GetMapping
    public ResponseEntity<List<Role>> getAllRoles(){
        var allRoles = roleRepository.findAll();
        return ResponseEntity.ok(allRoles);
    };

    @PostMapping
    public ResponseEntity<String> createRole(@RequestBody RoleDTO roleDTO) {
        // Verifique se o setor existe
        System.out.println("SETOR: " + roleDTO.getSectorName() + " ROLE: " + roleDTO.getName());
        Sector sector = sectorRepository.findById(roleDTO.getSectorName()).orElse(null);

        if (sector == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Setor não encontrado");
        }

        // Crie uma nova instância de Role e estabeleça a referência ao Sector

        String name = roleDTO.getName();
        Role role = new Role(name, sector);

        // Salve a nova função no banco de dados
        roleRepository.save(role);

        return ResponseEntity.status(HttpStatus.CREATED).body("Função criada com sucesso");
    }

}
