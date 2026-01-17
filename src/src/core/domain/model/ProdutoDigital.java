package core.domain.model;

import core.domain.interfaces.IRegradePreco;

public class ProdutoDigital extends Produto {

    public ProdutoDigital(String nome, String descricao, double preco, int quant, IRegradePreco regraDePreco) {
        super(nome,descricao, preco, quant, regraDePreco);
    }

    //não tem o calcular frete
}
