package core.domain.model;

import core.domain.interfaces.IRegradePreco;

public class Livro extends ProdutoFisico {

    public Livro(String nome, String descricao, double peso, double preco, int quant, IRegradePreco regraDePreco) {
        super(nome, descricao, peso, preco, quant, regraDePreco);
    }
}
