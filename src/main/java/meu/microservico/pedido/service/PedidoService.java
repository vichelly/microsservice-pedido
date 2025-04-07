package meu.microservico.pedido.service;

import java.util.List;

import org.springframework.stereotype.Service;

import meu.microservico.pedido.model.ItemPedido;
import meu.microservico.pedido.model.Pedido;
import meu.microservico.pedido.repository.PedidoRepository;

@Service
public class PedidoService {
    
    private final PedidoRepository pedidoRepository;

    public PedidoService(PedidoRepository pedidoRepository){
        this.pedidoRepository = pedidoRepository;
    }

    public Pedido salvarPedido(Pedido pedido){
        if(pedido.getItens() != null){
            for(ItemPedido item: pedido.getItens()){
                item.setPedido(pedido);
            }
        }
        return pedidoRepository.save(pedido);
    }

    public List<Pedido> listarPedidos(){
        return pedidoRepository.findAll();
    }

}
