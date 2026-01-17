package infra.services;


public class PagamentoCartao implements IPagamento {

    @Override
    public boolean processarPagamento(double valor) {
        if (valor <= 0) {
            return false;
        }

        return true;
    }
}