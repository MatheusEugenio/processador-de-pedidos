package core.model.tiposDeProduto;

import core.model.Produto;

public class ProdutoDigital extends Produto {

    public ProdutoDigital(String nome, String descricao, double preco, int quant) {
        super(nome, descricao, preco, quant);
    }

    //não tem o calcular frete
}
