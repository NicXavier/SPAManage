package com.spamanage.demo.model;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.DecimalMin;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class serviceType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @NotNull(message = "Digite aqui o tipo de serviço:")
    @Size(min = 3, max = 50, message = "O nome do serviço deve ter entre 3 e 50 caracteres.")
    private String serviceType;

    @NotNull(message = "Digite aqui a descrição do serviço:")
    @Size(min = 10, max = 200, message = "A descrição do serviço deve ter entre 10 e 200 caracteres.")
    private String serviceDescription;

    @NotNull(message = "Digite aqui a duração do serviço:")
    @Min(value = 1, message = "A duração do serviço deve ser no mínimo 1 minuto.")
    private Integer serviceDuration;

    @NotNull(message = "Digite aqui o preço do serviço:")
    @DecimalMin(value = "0.01", message = "O preço do serviço deve ser maior do que 0.")
    private Double servicePrice;
    
}
