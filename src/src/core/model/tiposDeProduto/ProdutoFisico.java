package core.model.tiposDeProduto;

import core.model.Produto;

public class ProdutoFisico extends Produto {

    public ProdutoFisico(String nome, String tipo,String descricao, double preco, int quant) {
        super(nome, tipo,descricao, preco, quant);
    }

    @Override
    public void precificacao() {

    }
}
