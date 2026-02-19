package core.domain.model;

import core.domain.services.EmailNotificador;
import core.domain.usecases.BuscaDeItemEmPedido;
import core.domain.interfaces.IPagamento;
import core.domain.usecases.CalculadoraDeFrete;
import infra.util.StatusDoPedido;

import java.time.LocalDate;
import java.util.*;

public class Pedido {

        private static int contador = 1;

        private Cliente cliente;
        private LocalDate dataDeCompra; // revisar pois não está sendo usado
        private List<ItemPedido> itensNoCarrinho;
        private boolean estaPago;
        private int ID;
        private StatusDoPedido staus;

        public Pedido(Cliente cliente){
            this.cliente = cliente;
            validate(cliente);

            this.itensNoCarrinho = new ArrayList<>();
            this.dataDeCompra = LocalDate.now();
            this.estaPago = false;
            this.ID = contador++;
        }

        private double calcularValorTotalDoPedido(){

            double valorTotalDosItens =  itensNoCarrinho.stream()
                    .mapToDouble(item -> item.getProduto().getQuantidadeEstoque() * item.getPrecoUnitario())
                    .sum();

            return valorTotalDosItens + CalculadoraDeFrete.calcularFreteTotal(itensNoCarrinho);
        }

        public void adicionarItem(ItemPedido item) {
            if (item == null){
                throw new IllegalArgumentException("Erro ao adicionar produto: o produto é nulo, inválido!");
            }

            if (!this.itensNoCarrinho.isEmpty()){
                setStaus(StatusDoPedido.EM_ANDAMENTO);
            }

            itensNoCarrinho.add(item);
        }

        public void removerItem(ItemPedido item) {
            if (item == null){
                throw new IllegalArgumentException("Erro ao remover produto do pedido: o produto é nulo!");
            }

            if(this.itensNoCarrinho.isEmpty()){
                throw new IllegalArgumentException("Erro ao remover item do pedido: o pedido está vazia, impossível remover!");
            }

            itensNoCarrinho.removeIf(itemDalista ->
                    itemDalista.getProduto() != null
                        && itemDalista.getProduto().getNomeDoProduto().equalsIgnoreCase(item.getProduto().getNomeDoProduto())
                        && itemDalista.getPrecoUnitario() == item.getPrecoUnitario()
            );
        }

        public void editarItem(ItemPedido item, int quant){

            if (item == null){
                throw new IllegalArgumentException("Erro ao editar produto: o produto é nulo!");
            }

            boolean estaNaLista = itensNoCarrinho.contains(item);
            if (!estaNaLista){
                throw new NoSuchElementException("Erro ao editar produto : o item "+item.getProduto().getNomeDoProduto()+" não está presente na sua lista de pedidos!");
            }

            Optional<ItemPedido> itemEncontradoOP = BuscaDeItemEmPedido.buscaItemEmPedido(item, itensNoCarrinho);
            ItemPedido itemEncontrado = itemEncontradoOP.orElseThrow(() -> new NoSuchElementException("Erro: Item não encontrado na busca detalhada."));

            itemEncontrado.mudarQuantidade(quant);
        }

        public void pagarPedido(IPagamento tipoPagamento){
            if (this.itensNoCarrinho.isEmpty()){
                throw new IllegalStateException("Erro no pagamento do pedido: Nenhum item encontrado na lista!");
            }

            if (estaPago){
                throw new IllegalStateException("Atenção! O pedido já está pago!");
            }

            boolean pago = tipoPagamento.pagar(calcularValorTotalDoPedido());

            if (!pago){
                throw new RuntimeException("Erro ao pagar!");
            }

            this.estaPago = true;
            System.out.println("Pedido pago com sucesso!");
            EmailNotificador emailNotificador = new EmailNotificador();
            emailNotificador.notificar(this);
            //enviar comando de email
        }

        private void validate(Cliente cliente){
            if (cliente == null){
                throw new IllegalArgumentException("Impossível criar esse pedido, pois o cliente não é válido!");
            }
        }

        public int getID() {return ID;}
        public String getNomeDoCliente() {return cliente.getNome();}
        public void setStaus(StatusDoPedido staus) {this.staus = staus;}
        public List<ItemPedido> getItensNoCarrinho() {return this.itensNoCarrinho;}

}