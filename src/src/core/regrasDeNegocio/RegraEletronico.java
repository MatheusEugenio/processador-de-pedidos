package core.regrasDeNegocio;

import core.interfaces.IRegradePreco;

public class RegraEletronico implements IRegradePreco {
    @Override
    public double calcularPrecoFinal(double valorOriginal) {
        return valorOriginal * 0.95;
    }
}
