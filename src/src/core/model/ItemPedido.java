package core.model;

public class ItemPedido {

    private Produto produto;
    private int quantidade;
    private double precoUnitario;

    public ItemPedido(Produto produto, int quantidade) {
        if (produto == null){
            throw new IllegalArgumentException("produto nulo!");
        }

        this.produto = produto;
        this.quantidade = quantidade;
        this.precoUnitario = produto.getPrecoFinal();
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Produto getProduto() {return produto;}
    public int getQuantidade() {return quantidade;}
    public double getPrecoUnitario() {return precoUnitario;}
}
