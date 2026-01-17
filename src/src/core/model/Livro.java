package core.model;

import core.model.tiposDeProduto.ProdutoFisico;

public class Livro extends ProdutoFisico {

    public Livro(String nome, String tipo, String descricao, double preco, int quant) {
        super(nome, tipo, descricao, preco, quant);
    }
}
