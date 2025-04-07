package meu.microservico.pedido.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class ItemPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private int quantidade;

    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

    
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public Pedido getPedido() {
        return pedido;
    }
    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public int getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
