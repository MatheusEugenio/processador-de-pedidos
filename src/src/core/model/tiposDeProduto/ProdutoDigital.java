package core.model.tiposDeProduto;

import core.interfaces.IRegradePreco;
import core.model.Produto;

public class ProdutoDigital extends Produto {

    public ProdutoDigital(String nome, String descricao, double preco, int quant, IRegradePreco regraDePreco) {
        super(nome,descricao, preco, quant, regraDePreco);
    }

    //não tem o calcular frete
}
