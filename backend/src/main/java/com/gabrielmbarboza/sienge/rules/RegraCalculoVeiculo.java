package com.gabrielmbarboza.sienge.rules;

import com.gabrielmbarboza.sienge.exception.KmRodadoNegativoException;

public interface RegraCalculoVeiculo {
    Double calcularCustoTotal(Double custo) throws KmRodadoNegativoException;
}
