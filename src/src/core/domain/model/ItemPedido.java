package core.domain.model;

public class ItemPedido {

    private Produto produto;
    private double precoUnitario;

    public ItemPedido(Produto produto) {
        validate(produto);

        this.produto = produto;
        this.precoUnitario = produto.getPrecoFinal();
    }

    private void validate(Produto produto){
        if (produto == null){
            throw new IllegalArgumentException("Erro ao criar um ItemPedido, o produto nulo!");
        }
    }

    public void mudarQuantidade(int quantidade) {this.produto.setQuantidadeEstoque(quantidade);}
    public Produto getProduto() {return produto;}
    public String getNomeDoProduto() {return produto.getNomeDoProduto();}
    public double getPrecoUnitario() {return precoUnitario;}
    public int getQuantidadeEmEstoqueDoProduto(){return produto.getQuantidadeEstoque();}

}
