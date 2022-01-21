package com.gabrielmbarboza.sienge.rules;

import com.gabrielmbarboza.sienge.exception.KmRodadoNegativoException;

public class RegraCalculoVeiculoCarreta implements RegraCalculoVeiculo {
    private final Double fmc = 1.12;

    public Double calcularCustoTotal(Double custo) {
        return custo * fmc;
    }
}
