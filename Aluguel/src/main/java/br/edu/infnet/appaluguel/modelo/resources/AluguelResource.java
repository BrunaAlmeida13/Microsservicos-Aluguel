package br.edu.infnet.appaluguel.modelo.resources;

import br.edu.infnet.appaluguel.modelo.resources.dto.AluguelDTO;
import br.edu.infnet.appaluguel.modelo.resources.dto.ClienteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/alugueis")
public class AluguelResource {
    @Autowired
    private RestTemplate restTemplate;
/*
    @Autowired
    private EquipamentoClient equipamentoClient;
*/
    @Value("${cliente.endpoint.url}")
    private String clienteApiUrl;

    @PostMapping
    public void alugaEquipamento(@RequestBody AluguelDTO aluguelDTO){
        ClienteDTO clienteDTO = restTemplate.getForObject(clienteApiUrl + aluguelDTO.getClienteId(),
                                ClienteDTO.class);
    }
}
