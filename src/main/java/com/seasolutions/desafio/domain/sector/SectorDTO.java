package com.seasolutions.desafio.domain.sector;

import lombok.Getter;

@Getter
public class SectorDTO {
    private String name;
    public Sector toObject() { return new Sector(name); }
}
