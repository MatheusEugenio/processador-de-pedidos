package core.model;

import core.interfaces.IRegradePreco;

public abstract class Produto implements IRegradePreco {

    private String nome;
    private String descricao;
    private String tipoDoProduto;
    private double precoInicial;
    private int quantidadeInicialDeEstoque;
    private int ID;
    private boolean disponivel = false;

    public Produto(String nome, String tipo, String descricao, double preco, int quant) {
        this.nome = nome;
        this.tipoDoProduto = tipo;
        this.descricao = descricao;
        this.precoInicial = preco;
        this.quantidadeInicialDeEstoque = quant;
        this.disponivel = true;
    }

    public int getID() {return ID;}
    public String getTipoDoProduto() {return tipoDoProduto;}
    public String getNome() {return nome;}
    public String getDescricao() {return descricao;}
    public double getPrecoInicial() {return precoInicial;}
    public boolean isDisponivel() {return disponivel;}
    public void setNome(String nome) {this.nome = nome;}
    public void setPrecoInicial(double precoInicial) {this.precoInicial = precoInicial;}
    public void setQuantidadeInicialDeEstoque(int quantidadeInicialDeEstoque) {this.quantidadeInicialDeEstoque = quantidadeInicialDeEstoque;}
    public int getQuantidadeInicialDeEstoque() {return quantidadeInicialDeEstoque;}
    public void setDescricao(String descricao) {this.descricao = descricao;}
    public void setDisponivel(boolean disponivel) {this.disponivel = disponivel;}
}
