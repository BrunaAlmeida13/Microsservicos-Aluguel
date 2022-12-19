package br.edu.infnet.appaluguel.modelo.resources;

import br.edu.infnet.appaluguel.modelo.clients.EquipamentoClient;
import br.edu.infnet.appaluguel.modelo.resources.dto.AluguelDTO;
import br.edu.infnet.appaluguel.modelo.resources.dto.AluguelResponseDTO;
import br.edu.infnet.appaluguel.modelo.resources.dto.ClienteDTO;
import br.edu.infnet.appaluguel.modelo.resources.dto.EquipamentoDTO;
import io.swagger.v3.oas.annotations.Operation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/alugueis")
public class AluguelResource {

    private static Logger log = LoggerFactory.getLogger(AluguelResource.class);

    @Autowired
    private RestTemplate restTemplate;

    @Value("${cliente.endpoint.url}")
    private String clienteApiUrl;

    @Autowired
    private EquipamentoClient equipamentoClient;

    @Operation(summary = "Método para aluguel de equipamento", description = "Endpoint para registro de aluguel")
    @PostMapping
    public AluguelResponseDTO alugaEquipamento(@RequestBody AluguelDTO aluguelDTO) {
        log.trace("TraceID");
        log.info("Solicitação para aluguel de equipamento | Descrição: {" + aluguelDTO + "}");

        if (log.isDebugEnabled())
            log.debug("Debug iniciado");

        ClienteDTO clienteDTO = restTemplate.getForObject(clienteApiUrl + aluguelDTO.getClienteId(),
                ClienteDTO.class);

        log.info("Chamada da API de clientes realizada: " + clienteDTO);

        ResponseEntity<List<EquipamentoDTO>> equipamentos = equipamentoClient.getEquipamentos();

        return new AluguelResponseDTO(clienteDTO, equipamentos.getBody());
    }
}
