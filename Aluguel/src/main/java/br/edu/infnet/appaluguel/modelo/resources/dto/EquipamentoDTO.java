package br.edu.infnet.appaluguel.modelo.resources.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class EquipamentoDTO {
    private Long cdEquipamento;

    private String nome;

    private BigDecimal valorCompra;

    private BigDecimal valorUnitarioAluguel;

    private int quantidade;
}
