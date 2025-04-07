package meu.microservico.pedido.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import meu.microservico.pedido.model.Pedido;
import meu.microservico.pedido.service.PedidoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private final RabbitTemplate rabbitTemplate;

    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService, RabbitTemplate rabbitTemplate){
        this.pedidoService = pedidoService;
        this.rabbitTemplate = rabbitTemplate;
    }

    @PostMapping
    public String criarPedido(@RequestBody Pedido pedido) {
        Pedido pedidoSalvo = pedidoService.salvarPedido(pedido);
        rabbitTemplate.convertAndSend(pedidoSalvo);

        return "Pedido salvo e enviado para processamento: "+pedido.getDescricao();
    }
    
    @GetMapping()
    public List<Pedido> listarPedidos() {
        return pedidoService.listarPedidos();
    }
    

}
