package br.edu.infnet.appaluguel.modelo.resources.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class AluguelResponseDTO {

    private ClienteDTO clienteDTO;

    private List<EquipamentoDTO> listaEquipamentoDTO;
}
