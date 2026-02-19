package infra.gateways;

import core.domain.interfaces.IPagamento;

public class PagamentoPix implements IPagamento {

    @Override
    public boolean pagar(double valor) {
        if (valor <= 0) {
            return false;
        }

        /*falta a regra de negócio de pagamento*/
        return true;
    }
}
