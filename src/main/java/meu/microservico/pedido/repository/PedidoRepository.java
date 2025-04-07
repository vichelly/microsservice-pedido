package meu.microservico.pedido.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import meu.microservico.pedido.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long>{

} 
