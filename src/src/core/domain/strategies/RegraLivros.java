package core.domain.strategies;

import core.domain.interfaces.IRegradePreco;

public class RegraLivros implements IRegradePreco {
    @Override
    public double calcularPrecoFinal(double valorOriginal) {
        return valorOriginal;
    }
}
