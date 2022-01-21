package com.gabrielmbarboza.sienge.rules;

public class RegraCalculoVeiculoCaminhaoCacamba implements RegraCalculoVeiculo {
    private final Double fmc = 1.05;

    public Double calcularCustoTotal(Double custo) {
        return custo * fmc;
    }
}
