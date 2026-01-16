package infra.services.modelPagamento;

import core.interfaces.IPagamento;
import infra.services.Pagamento;

public class PagamentoPix extends Pagamento implements IPagamento {
    @Override
    public void pagar() {

    }

    @Override
    public IPagamento obterMecanismoDePagamento() {
        return this;
    }
}
