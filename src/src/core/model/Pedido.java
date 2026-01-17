package core.model;

import core.usecases.BuscaDeItemEmPedido;
import infra.services.IPagamento;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class Pedido {

        private Cliente cliente;
        private LocalDate dataDeCompra;
        private List<ItemPedido> itensNoCarrinho;
        private boolean estaPago;

        public Pedido(Cliente comprador){
            this.cliente = comprador;
            this.itensNoCarrinho = new ArrayList<>();
            this.dataDeCompra = LocalDate.now();
            this.estaPago = false;
        }

        public void envioTransportadora(){

        }

        public void adicionarItem(ItemPedido item) {
            if (item == null){
                throw new IllegalArgumentException("produto é nulo, inválido!");
            }

            itensNoCarrinho.add(item);
        }

        public void removerItem(ItemPedido item){
            if (item == null){
                throw new IllegalArgumentException("produto ou cliente ou ambos são nulos!");
            }

            itensNoCarrinho.removeIf(itemDalista ->
                    itemDalista.getProduto() != null
                        && itemDalista.getProduto().getNome().equalsIgnoreCase(item.getProduto().getNome())
                        && itemDalista.getPrecoUnitario() == item.getPrecoUnitario()
            );
        }

        public void editarItem(ItemPedido item, int quant){
            if (item == null){
                throw new IllegalArgumentException("produto ou cliente ou ambos são nulos!");
            }

            boolean estaNaLista = itensNoCarrinho.contains(item);
            if (!estaNaLista){
                throw new NoSuchElementException("O item "+item.getProduto().getNome()+" não está presente na sua lista de pedidos!");
            }

            Optional<ItemPedido> itemEncontradoOP = BuscaDeItemEmPedido.buscaItemEmPedido(item, itensNoCarrinho);
            ItemPedido itemEncontrado = itemEncontradoOP.orElseThrow(() -> new NoSuchElementException("Erro: Item não encontrado na busca detalhada."));

            itemEncontrado.setQuantidadeDoProduto(quant);
        }

        public double calcularTotal(){
            double precoTotal = 0;
            for (ItemPedido item : itensNoCarrinho){
                precoTotal += (item.getQuantidadeDoProduto() * item.getPrecoUnitario());
            }

            //lógica de desconto
            return precoTotal;
        }

        public void pagarPedido(IPagamento tipoPagamento){
            if (this.itensNoCarrinho.isEmpty()){
                throw new IllegalStateException("Nenhum item encontrado na lista!");
            }

            if (estaPago){throw new IllegalStateException("Pedido já está pago!");}

            double valorTotalPagar = calcularTotal();

            boolean pago = tipoPagamento.processarPagamento(valorTotalPagar);

            if (pago){
                this.estaPago = true;
                System.out.println("Pedido pago com sucesso!");
                //enviar comando de email
            }else {
                throw new RuntimeException("Erro ao pagar!");
            }
        }

        public Cliente getCliente() {return cliente;}
        public LocalDate getDataDeCompra() {return dataDeCompra;}
        public List<ItemPedido> getItensNoCarrinho() {return itensNoCarrinho;}
}