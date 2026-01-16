package core.model;

public class ItemPedido {

    private Produto produto;
    private int quantidadeDoProduto;
    private double precoUnitario;

    public ItemPedido(Produto produto, int quantidadeDoProduto, double precoUnitario) {
        if (produto != null){this.produto = produto;}
        if (quantidadeDoProduto > 0 ){this.quantidadeDoProduto = quantidadeDoProduto;}
        if(precoUnitario > 0){this.precoUnitario = precoUnitario;}
    }

    public Produto getProduto() {return produto;}
    public int getQuantidadeDoProduto() {return quantidadeDoProduto;}
    public double getPrecoUnitario() {return precoUnitario;}
}
