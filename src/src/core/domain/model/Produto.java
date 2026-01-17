package core.domain.model;

import core.domain.interfaces.IRegradePreco;

public abstract class Produto {

    protected int ID;
    protected String nome;
    protected String descricao;
    protected double precoBase;
    protected int quantidadeEstoque;
    protected boolean disponivel;
    protected IRegradePreco regraDePreco;

    public Produto(String nome, String descricao, double precoBase, int quant, IRegradePreco regraDePreco) {
        this.nome = nome;
        this.descricao = descricao;
        this.precoBase = precoBase;
        this.quantidadeEstoque = quant;
        this.regraDePreco = regraDePreco;

        this.disponivel = this.quantidadeEstoque > 0;
    }

    public double getPrecoFinal() {
        return regraDePreco.calcularPrecoFinal(this.precoBase);
    }

    public int getID() {return ID;}
    public String getNome() {return nome;}
    public String getDescricao() {return descricao;}
    public double getPrecoBase() {return precoBase;}
    public boolean isDisponivel() {return disponivel;}
    public void setQuantidadeEstoque(int quantidadeEstoque) {this.quantidadeEstoque = quantidadeEstoque;}
    public int getQuantidadeEstoque() {return quantidadeEstoque;}
    public void setDisponivel(boolean disponivel) {this.disponivel = disponivel;}
}
