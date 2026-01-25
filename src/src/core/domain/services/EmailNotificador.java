package core.domain.services;

import core.domain.interfaces.INotificador;
import core.domain.model.Pedido;

public class EmailNotificador implements INotificador {

    @Override
    public void notificar(Pedido pedido) {
        System.out.println("📧 Enviando e-mail para: " + pedido.getCliente().getNome());
        System.out.println("Pedido " + pedido.getID() + " confirmado com sucesso.");
    }
}
