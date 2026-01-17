package core.domain.model;

import core.domain.interfaces.IRegradePreco;

public class Ebook extends ProdutoDigital {

    public Ebook(String nome, String descricao, double preco, int quant, IRegradePreco regraDePreco) {
        super(nome, descricao, preco, quant, regraDePreco);
    }
}
