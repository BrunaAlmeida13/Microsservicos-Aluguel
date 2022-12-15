package br.edu.infnet.appaluguel.modelo.resources;

import br.edu.infnet.appaluguel.modelo.clients.EquipamentoClient;
import br.edu.infnet.appaluguel.modelo.resources.dto.AluguelDTO;
import br.edu.infnet.appaluguel.modelo.resources.dto.AluguelResponseDTO;
import br.edu.infnet.appaluguel.modelo.resources.dto.ClienteDTO;
import br.edu.infnet.appaluguel.modelo.resources.dto.EquipamentoDTO;
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
    @Autowired
    private RestTemplate restTemplate;

    @Value("${cliente.endpoint.url}")
    private String clienteApiUrl;

    @Autowired
    private EquipamentoClient equipamentoClient;

    @PostMapping
    public AluguelResponseDTO alugaEquipamento(@RequestBody AluguelDTO aluguelDTO){
        ClienteDTO clienteDTO = restTemplate.getForObject(clienteApiUrl + aluguelDTO.getClienteId(),
                                ClienteDTO.class);

        ResponseEntity<List<EquipamentoDTO>> equipamentos = equipamentoClient.getEquipamentos();

        System.out.println("Aluguel: " + aluguelDTO);
        System.out.println("Equipamento pelo cliente" + equipamentoClient.getEquipamentos());
        System.out.println("Equipamento corpo: " + equipamentos.getBody());

        return new AluguelResponseDTO(clienteDTO, equipamentos.getBody());
    }
}
