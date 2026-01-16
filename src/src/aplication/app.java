package aplication;

import core.interfaces.IPagamento;
import infra.controller.ControllerPagamento;

public class app {
    public static void main(String[] args) {
        IPagamento pagamento = ControllerPagamento.meioDePagamento("pix");
        pagamento.pagar();
    }
}
