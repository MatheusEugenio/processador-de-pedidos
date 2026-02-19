package infra.repository;

import core.domain.model.ItemPedido;
import core.domain.model.Pedido;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;

public class Persistencia {

    private String caminho = "infra/repository/arqPedido";
    private File arqPedido = new File(caminho);

    public void registrarItemNoLogDePedidos(Pedido pedido, ItemPedido item){

        try(BufferedWriter escritor = new BufferedWriter(new FileWriter(caminho))){



        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void removerItemNoLogDePedidos(Pedido pedido, ItemPedido item) throws IOException {

            boolean estaPresenteNoPedido = pedido.getItensNoCarrinho().contains(item);
            if (!estaPresenteNoPedido){
                throw new NoSuchElementException("Erro ao remover produto: o item não está no pedido, impossível remover!");
            }

            pedido.getItensNoCarrinho().remove(item);
            escreverNoLogDePedidos(pedido.getItensNoCarrinho());//recarregar e re-escrever os itens no pedido
    }

    private void escreverNoLogDePedidos(List<ItemPedido> itens) throws IOException {
        if (itens.isEmpty()){
            throw new IllegalArgumentException("Erro: a lista de itens é nula!"); //rever o tipo dessa exceção
        }

        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(caminho))) {



        } catch (IOException e) {
            throw new IOException("Erro na manipulação do arquivo: "+ e.getMessage());
        }
    }
}
