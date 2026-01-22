package core.domain.services;

import core.domain.model.Pedido;

public class Carrinho {

    private Pedido pedido;

    public Carrinho(Pedido pedido){
        if (pedido == null){
            throw new IllegalArgumentException("Não se pode adicionar um pedido vazio no carrinho!");
        }

        this.pedido = pedido;
    }

    public void vizualizarCarrinho(){

    }

    public void finalizarCompraDoCarrinho(){

    }

    public void editarPedidoDoCarrinho(/*o que tem que ser mudado => QUAL PRODUTO*/){
    }
}
