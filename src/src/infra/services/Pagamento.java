package infra.services;

import core.interfaces.IPagamento;
import core.model.Cliente;
import core.model.Pedido;

public class Pagamento {

    private Cliente cliente;
    private double valor;
    private Pedido pedido;

    public Pagamento(Cliente cliente,double valor,Pedido pedido) {
        this.cliente = cliente;
        this.valor = valor;
        this.pedido = pedido;
    }

    public abstract IPagamento obterMecanismoDePagamento();
}
