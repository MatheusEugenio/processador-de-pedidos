package core.domain.model.implementacoes;

import core.domain.interfaces.IRegradePreco;
import core.domain.model.ProdutoFisico;

public class Eletronico extends ProdutoFisico {

    public Eletronico(String nome, String descricao, double peso, double preco, int quant, IRegradePreco regraDePreco) {
        super(nome, descricao, peso, preco, quant, regraDePreco);
    }
}
