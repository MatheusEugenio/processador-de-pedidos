package core.model.tiposDeProduto;

import core.interfaces.IRegradePreco;
import core.interfaces.ITransportavel;

public class ProdutoFisico extends Produto implements ITransportavel {
    private double peso;

    public ProdutoFisico(String nome, String descricao, double peso, double preco, int quant, IRegradePreco regraDePreco) {
        super(nome, descricao, preco, quant, regraDePreco);
    }

    public double getPeso() {return peso;}

    @Override
    public double calcularFrete() {
        return peso * 5.0; //simbólico
    }
}
