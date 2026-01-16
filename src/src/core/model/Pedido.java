package core.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Pedido { //como se fosse o carrrinho

    private Cliente cliente;
    private LocalDate dataDeCompra;
    private List<ItemPedido> itensNoCarrinho;

    public Pedido(Cliente comprador){
        this.cliente = comprador;
        this.itensNoCarrinho = new ArrayList<>();
        this.dataDeCompra = LocalDate.now();
    }

    public double calcularTotal(){
        double precoTotal = 0;
        for (ItemPedido item : itensNoCarrinho){
            precoTotal += (item.getQuantidadeDoProduto() * item.getPrecoUnitario());
        }

        return precoTotal;
    }

    
    public Cliente getCliente() {return cliente;}
    public LocalDate getDataDeCompra() {return dataDeCompra;}
    public List<ItemPedido> getItensNoCarrinho() {return itensNoCarrinho;}
}
