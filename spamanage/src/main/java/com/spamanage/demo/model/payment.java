package com.spamanage.demo.model;

import com.spamanage.demo.enums.paymentStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;

@Entity
@Table(name = "payments")
@Getter
@Setter
public class payment {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotEmpty(message = "O tipo de pagamento é obrigatório.")
    private String paymentType;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @NotNull(message = "O status do pagamento é obrigatório.")
    private paymentStatus paymentStatus;

    @Column(nullable = false)
    @NotNull(message = "O valor do pagamento é obrigatório.")
    @DecimalMin(value = "0.01", message = "O valor deve ser maior que zero.")
    private BigDecimal paymentAmount;

    //@Column        futura implementação
    //@Size( max = 255, message = "O comprovante deve ter no máximo 255 caracteres")
    //private String paymentReceipt;

    public payment() {}

    public payment(String paymentType, paymentStatus paymentStatus, BigDecimal paymentAmount) {
        this.paymentType = paymentType;
        this.paymentStatus = paymentStatus;
        this.paymentAmount = paymentAmount;
       // implementar futuramente:  this.paymentReceipt = paymentReceipt;
    }

}
