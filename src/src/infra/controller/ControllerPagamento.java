package infra.controller;

import core.interfaces.IPagamento;
import infra.services.modelPagamento.PagamentoBoleto;
import infra.services.modelPagamento.PagamentoCartao;
import infra.services.modelPagamento.PagamentoPix;

public class ControllerPagamento {

    public static IPagamento meioDePagamento(String tag){
        if (tag.equalsIgnoreCase("pix")){
            return new PagamentoPix();

        }else if (tag.equalsIgnoreCase("boleto")){
            return new PagamentoBoleto();

        }else if (tag.equalsIgnoreCase("cartão")){
            return new PagamentoCartao();

        }else {

        }
    }
}
