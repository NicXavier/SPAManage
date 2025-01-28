package com.spamanage.demo.enums;

import lombok.Getter;

@Getter
public class PackageStatus {
    ACTIVE("Ativo"),
    INATIVE("Inativo"),
    PROMOTION("Em promoção"),
    CANCELED("Cancelado");

    private final String description;

    PackageStatus(String description) {
        this.description = description;
    }
    
}
