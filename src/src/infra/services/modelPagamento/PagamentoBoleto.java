package infra.services.modelPagamento;

import core.interfaces.IPagamento;
import core.model.Cliente;
import infra.services.Pagamento;
import core.model.Pedido;

public class PagamentoBoleto extends Pagamento implements IPagamento {
    public PagamentoBoleto(Cliente cliente, double valor, Pedido pedido) {
        super(cliente, valor, pedido);
    }

    @Override
    public void pagar() {

    }

    @Override
    public IPagamento obterMecanismoDePagamento() {
        return this;
    }
}
