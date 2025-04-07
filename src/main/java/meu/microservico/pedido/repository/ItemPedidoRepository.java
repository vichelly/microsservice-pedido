package meu.microservico.pedido.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import meu.microservico.pedido.model.ItemPedido;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Long> {
    
}
