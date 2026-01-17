package infra.gateways;


import core.domain.interfaces.IPagamento;

public class PagamentoCartao implements IPagamento {

    @Override
    public boolean processarPagamento(double valor) {
        if (valor <= 0) {
            return false;
        }

        return true;
    }
}