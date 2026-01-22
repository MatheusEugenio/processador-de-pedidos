package core.domain.usecases;

import core.domain.interfaces.ITransportavel;
import core.domain.model.ItemPedido;

import java.util.List;

public class CalculadoraDeFrete {

    public static double calcularFreteTotal(List<ItemPedido> itens){
        if (itens == null || itens.isEmpty()){
            return 0;
        }

        return itens.stream()
                .filter( item -> item.getProduto() instanceof ITransportavel)
                .mapToDouble(item -> {
                    ITransportavel transportavel =  (ITransportavel) item.getProduto();

                    double freteUnitario = transportavel.calcularFrete();
                    return freteUnitario * item.getQuantidade();

                })
                .sum();
    }
}
