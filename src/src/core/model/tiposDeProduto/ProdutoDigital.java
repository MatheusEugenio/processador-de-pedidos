package core.model.tiposDeProduto;

import core.model.Produto;

public class ProdutoDigital extends Produto {

    public ProdutoDigital(String nome,String tipo, String descricao, double preco, int quant) {
        super(nome, tipo, descricao, preco, quant);
    }

    @Override
    public void precificacao() {

    }

    //não tem o calcular frete
}
