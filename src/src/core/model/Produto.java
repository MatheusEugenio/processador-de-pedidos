package core.model;

public abstract class Produto {

    private String nome;
    private String descricao;
    private double preco;
    private int quantidadeEstoque;
    private boolean disponivel = false;


    public Produto(String nome, String descricao, double preco, int quant) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.quantidadeEstoque = quant;
        this.disponivel = true;
    }

    public String getNome() {return nome;}
    public String getDescricao() {return descricao;}
    public double getPreco() {return preco;}
    public boolean isDisponivel() {return disponivel;}

    public void setNome(String nome) {this.nome = nome;}
    public void setPreco(double preco) {this.preco = preco;}
    public void setQuantidadeEstoque(int quantidadeEstoque) {this.quantidadeEstoque = quantidadeEstoque;}
    public int getQuantidadeEstoque() {return quantidadeEstoque;}
    public void setDescricao(String descricao) {this.descricao = descricao;}
    public void setDisponivel(boolean disponivel) {this.disponivel = disponivel;}
}
