package edu.infnet.aluguel.clientes.modelo.resources;

import edu.infnet.aluguel.clientes.modelo.entidades.Cliente;
import edu.infnet.aluguel.clientes.modelo.services.ClienteService;

import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class ClienteResource {

    private static final Logger log = LoggerFactory.getLogger(ClienteResource.class);

    @Autowired
    private ClienteService clienteService;


    @Operation(summary = "Método para buscar cliente", description = "Endpoint para buscar cliente por código (id)")
    @GetMapping("/clientes/{codigo}")
    public Cliente getCliente(@PathVariable Long codigo) {
        log.info("Chamada da API de cliente com código: [" + codigo + "]");

        return clienteService.getByCodigo(codigo);
    }
}
