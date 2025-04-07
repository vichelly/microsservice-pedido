package meu.microservico.pedido.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Pedido {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String descricao;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    private List<ItemPedido> itens;


    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }
    public void setItens(List<ItemPedido> itens) {
        this.itens = itens;
    }

}
