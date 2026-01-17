package core.model.tiposDeProduto;

import core.interfaces.IRegradePreco;
import core.model.Produto;

public class ProdutoFisico extends Produto {

    public ProdutoFisico(String nome, String descricao, double preco, int quant, IRegradePreco regraDePreco) {
        super(nome, descricao, preco, quant, regraDePreco);
    }

}
