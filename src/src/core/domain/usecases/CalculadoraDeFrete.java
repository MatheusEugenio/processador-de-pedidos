package core.domain.usecases;

import core.domain.interfaces.ITransportavel;
import core.domain.model.ItemPedido;

import java.util.List;

public class CalculadoraDeFrete {

    public static double calcularFreteTotal(List<ItemPedido> itens){
        if (itens == null || itens.isEmpty()){
            throw new IllegalArgumentException("A lista de itens não pode estar nula ou vazia para o cálculo de frete.");
        }

        return itens.stream()
                .filter( item -> item.getProduto() instanceof ITransportavel)
                .mapToDouble(item -> {
                    ITransportavel transportavel = (ITransportavel) item.getProduto();

                    double freteUnitario = transportavel.calcularFrete();
                    return freteUnitario * item.getQuantidadeEmEstoqueDoProduto();
                })
                .sum();
    }
}
