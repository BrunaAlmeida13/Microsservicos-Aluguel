package br.edu.infnet.appaluguel.modelo.clients;

import br.edu.infnet.appaluguel.modelo.resources.dto.EquipamentoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient("equipamento")
public interface AluguelClient {
    @RequestMapping("/equipamentos")
    List<EquipamentoDTO> getEquipamentos();
}
