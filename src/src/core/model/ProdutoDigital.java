package core.model;

import core.interfaces.IPagamento;

public class ProdutoDigital extends Produto implements IPagamento {

    public ProdutoDigital(String nome, String descricao, double preco, int quant) {
        super(nome, descricao, preco, quant);
    }

    @Override
    public void pagar() {

    }
}
