package core.domain.model.implementacoes;

import core.domain.interfaces.IRegradePreco;
import core.domain.model.ProdutoDigital;

public class Ebook extends ProdutoDigital {

    public Ebook(String nome, String descricao, double preco, int quant, IRegradePreco regraDePreco) {
        super(nome, descricao, preco, quant, regraDePreco);
    }
}
