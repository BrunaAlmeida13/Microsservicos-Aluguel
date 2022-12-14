package br.edu.infnet.appaluguel.modelo.resources.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ClienteDTO {
    private Long id;
    private String nome;
    private String cpf;
    private String telefone;
    private boolean whatsapp;
}
