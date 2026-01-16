package core.model;

import core.interfaces.IPagamento;

public class ProdutoFisico extends Produto implements IPagamento {


    public ProdutoFisico(String nome, String descricao, double preco, int quant) {
        super(nome, descricao, preco, quant);
    }

    @Override
    public void pagar() {

    }
}
