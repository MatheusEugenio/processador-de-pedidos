package core.domain.model;

import core.domain.interfaces.IRegradePreco;

public abstract class Produto {

    protected int ID;
    protected String nomeDoProduto;
    protected String descricao;
    protected double precoBase;
    protected int quantidadeEstoque;
    protected boolean disponivel;
    protected IRegradePreco regraDePreco; //funciona como o tipo do produto

    public Produto(String nomeDoProduto, String descricao, double precoBase, int quant, IRegradePreco regraDePreco) {
        this.nomeDoProduto = nomeDoProduto;
        this.descricao = descricao;
        this.precoBase = precoBase;
        this.quantidadeEstoque = quant;
        this.regraDePreco = regraDePreco;

        this.disponivel = this.quantidadeEstoque > 0;
    }

    public double getPrecoFinal() {
        return regraDePreco.calcularPrecoFinal(this.precoBase);
    }
    public int getQuantidadeEstoque() {return this.quantidadeEstoque;}
    public String getNomeDoProduto() {return nomeDoProduto;}
    public void setQuantidadeEstoque(int quantidadeEstoque) {this.quantidadeEstoque = quantidadeEstoque;}
}
