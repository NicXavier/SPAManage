package com.spamanage.demo.enums;

import lombok.Getter;

@Getter
public class packageStatus {
    ACTIVE("Ativo"),
    INATIVE("Inativo"),
    PROMOTION("Em promoção"),
    CANCELED("Cancelado");

    private final String description;

    packageStatus(String description) {
        this.description = description;
    }
    
}
