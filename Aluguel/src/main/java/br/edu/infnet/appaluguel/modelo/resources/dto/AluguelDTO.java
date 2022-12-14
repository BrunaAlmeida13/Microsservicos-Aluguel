package br.edu.infnet.appaluguel.modelo.resources.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class AluguelDTO {
    private Integer clienteId;

    private List<EquipamentoDTO> equipamentos;

}
