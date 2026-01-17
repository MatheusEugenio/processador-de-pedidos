package infra.services;

public interface IPagamento {
    boolean processarPagamento(double valor);
}
