package com.gabrielmbarboza.sienge.rules;

import com.gabrielmbarboza.sienge.exception.KmRodadoNegativoException;

public class RegraCalculoVeiculoCaminhaoBau implements RegraCalculoVeiculo {
    private final Double fmc = 1.00;

    public Double calcularCustoTotal(Double custo) {
        return custo * fmc;
    }
}
