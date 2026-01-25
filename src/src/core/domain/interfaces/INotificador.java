package core.domain.interfaces;

import core.domain.model.Pedido;

public interface INotificador {
    void notificar(Pedido pedido);
}
