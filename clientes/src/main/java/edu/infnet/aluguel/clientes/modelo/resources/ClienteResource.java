package edu.infnet.aluguel.clientes.modelo.resources;

import edu.infnet.aluguel.clientes.modelo.entidades.Cliente;
import edu.infnet.aluguel.clientes.modelo.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clientes")
public class ClienteResource {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/{codigo}")
    public Cliente getCliente(@PathVariable Long codigo){
        return null;
    }
}
