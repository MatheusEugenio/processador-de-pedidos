package core.domain.model;

public class ItemPedido {

    private Produto produto;
    private double precoUnitario;

    public ItemPedido(Produto produto) {
        if (produto == null){
            throw new IllegalArgumentException("produto nulo!");
        }

        this.produto = produto;
        this.precoUnitario = produto.getPrecoFinal();
    }

    public void setQuantidade(int quantidade) {this.produto.setQuantidadeEstoque(quantidade);}
    public Produto getProduto() {return produto;}
    public double getPrecoUnitario() {return precoUnitario;}
}
