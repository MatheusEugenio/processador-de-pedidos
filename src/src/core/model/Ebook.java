package core.model;

import core.model.tiposDeProduto.ProdutoDigital;

public class Ebook extends ProdutoDigital {

    public Ebook(String nome, String tipo, String descricao, double preco, int quant) {
        super(nome, tipo, descricao, preco, quant);
    }
}
