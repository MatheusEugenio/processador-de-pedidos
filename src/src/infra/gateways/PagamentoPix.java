package infra.gateways;

import core.domain.interfaces.IPagamento;

public class PagamentoPix implements IPagamento {

    @Override
    public boolean processarPagamento(double valor) {
        if (valor <= 0) {
            return false;
        }

        return true;
    }
}
