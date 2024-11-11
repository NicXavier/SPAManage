package com.spamanage.demo.model;

import com.spamanage.demo.enums.packageStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal; // classe utilizada para representar valores exatos
import java.time.LocalDateTime;

@Entity
@Table(name = "packages")
@Getter
@Setter
public class servicePackage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long packageId;

    @Column(nullable = false)
    @NotEmpty(message = "O campo 'Nome do Pacote' é obrigatório.")
    @Size(max = 100 , message = "O nome do pacote deve ter no máximo 100 caracteres.")
    private String packageName;

    @Column(nullable = false)
    @NotEmpty(message = "O campo 'Descrição' é obrigatório.")
    @Size(max = 500 , message = "A descrição deve ter no máximo 500 caracteres.")
    private String packageDescription;

    @Column(nullable = false)
    @NotEmpty(message = "O campo 'Duração' é obrigatório.")
    @Size(message = "A duração deve ser um valor positivo")
    private Integer packageDurationMinutes;

    @Column(nullable = false)
    @NotEmpty(message = "O campo 'Preço' é obrigatório.")
    @Size(message = "O preço deve ser um valor positivo")
    private BigDecimal packagePriceAmount;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private packageStatus packageStatus;

    @Column(nullable = false)
    private LocalDateTime packageCreatedDate;

    @Column(nullable = false)
    private LocalDateTime packageUpdatedDate;

    @PrePersist
    protected void onCreate() {
        this.packageCreatedDate = LocalDateTime.now();
        this.packageUpdatedDate = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.packageUpdatedDate = LocalDateTime.now();
    }
    
}
