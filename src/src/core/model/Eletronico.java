package core.model;

import core.model.tiposDeProduto.ProdutoFisico;

public class Eletronico extends ProdutoFisico {

    public Eletronico(String nome, String tipo, String descricao, double preco, int quant) {
        super(nome, tipo, descricao, preco, quant);
    }
}
