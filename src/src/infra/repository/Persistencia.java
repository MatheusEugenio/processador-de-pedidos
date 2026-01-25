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

    public void registrarItemNoLogDePedidos(Pedido pedido, ItemPedido item) throws IOException {

        try(BufferedWriter escritor = new BufferedWriter(new FileWriter(caminho))){
            if (pedido == null || item == null){
                throw new NullPointerException("Erro ao registrar produto: item ou pedido são nulos ou não existem!");
            }



        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void removerItemNoLogDePedidos(Pedido pedido, ItemPedido item) throws IOException {

            if (pedido == null || item == null) {
                throw new NullPointerException("Erro ao remover produto: item ou pedido são nulos ou não existem!");
            }

            boolean estaPresenteNoPedido = pedido.getItensNoCarrinho().contains(item);
            if (estaPresenteNoPedido){
                pedido.getItensNoCarrinho().remove(item);
            }else {
                throw new NoSuchElementException("Erro ao remover produto: o item não está no pedido, impossível remover!");
            }

            escreverNoLogDePedidos(pedido.getItensNoCarrinho());//recarregar e re-escrever os itens no pedido
    }

    private void escreverNoLogDePedidos(List<ItemPedido> itens) throws IOException {
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(caminho))) {
            if (itens == null || itens.isEmpty()){
                throw new IllegalArgumentException(""); //rever o tipo dessa exceção
            }


        } catch (IOException e) {
            throw new IOException("Erro na manipulação do arquivo: "+ e.getMessage());
        }
    }
}
