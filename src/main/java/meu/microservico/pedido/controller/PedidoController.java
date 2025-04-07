package meu.microservico.pedido.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import meu.microservico.pedido.model.Pedido;
import meu.microservico.pedido.service.PedidoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
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

    @Value("${broker.queue.processamento.name}")
    private String routingKey;

    @PostMapping
    public String criarPedido(@RequestBody Pedido pedido) {
        Pedido pedidoSalvo = pedidoService.salvarPedido(pedido);
        rabbitTemplate.convertAndSend("",routingKey,pedidoSalvo.getDescricao());

        return "Pedido salvo e enviado para processamento: "+pedido.getDescricao();
    }
    
    @GetMapping()
    public List<Pedido> listarPedidos() {
        return pedidoService.listarPedidos();
    }
    

}
