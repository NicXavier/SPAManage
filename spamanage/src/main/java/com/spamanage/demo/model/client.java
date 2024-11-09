package com.spamanage.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Entity
@Table(name = "clients")
@Getter
@Setter
public class client {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotEmpty(message = "O campo nome é obrigatório.")
    private String clientName;

    @Column(nullable = false, unique = true)
    @NotEmpty(message = "O campo CPF é obrigatório.")
    private String cpf;

    @Column(nullable = false, unique = true)
    @Email(message = "E-mail inválido!")
    @NotEmpty(message = "O campo e-mail é obrigatório.")
    private String email;
    
    @Column(nullable = false)
    @NotEmpty(message = "O campo telefone é obrigatório.")
    private String phone;

    @Column(nullable = false)
    @NotEmpty(message = "O campo endereço é obrigatório.")
    private String homeAddress;

    @Column(nullable = false)
    @NotEmpty(message = "A data de nascimento não pode ser nula.")
    private LocalDate birthDate;

    public client() {}

    public client(String clientName, String cpf, String email, String phone, String homeAddress) {
        this.clientName = clientName;
        this.cpf = cpf;
        this.email = email;
        this.phone = phone;
        this.homeAddress = homeAddress;
        this.birthDate = birthDate;
    }

}
