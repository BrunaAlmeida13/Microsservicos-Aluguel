package edu.infnet.aluguel.clientes.modelo.services;

import edu.infnet.aluguel.clientes.modelo.entidades.Cliente;
import edu.infnet.aluguel.clientes.modelo.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente getByCodigo(Long codigo){
        return clienteRepository.findById(codigo).get();
    }
}
