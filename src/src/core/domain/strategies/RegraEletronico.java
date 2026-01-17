package core.domain.strategies;

import core.domain.interfaces.IRegradePreco;

public class RegraEletronico implements IRegradePreco {
    @Override
    public double calcularPrecoFinal(double valorOriginal) {
        return valorOriginal * 0.95;
    }
}
