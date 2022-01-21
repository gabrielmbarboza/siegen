package com.gabrielmbarboza.sienge.rules;

import com.gabrielmbarboza.sienge.exception.KmRodadoNegativoException;
import com.gabrielmbarboza.sienge.exception.PesoCargaNegativoException;
import com.gabrielmbarboza.sienge.model.TipoCaminhao;

public interface RegraCalculoViaTerrestre {
    Double calcularCustoTotal(TipoCaminhao tipoCaminhao, int kmRodado, int pesoCarga);

    Double calcularCustoKmRodado(int kmRodado) throws KmRodadoNegativoException;

    Double calcularPesoExcedente(int kmRodado, int pesoCarga) throws PesoCargaNegativoException;

    Boolean isPesoExcedente(int pesoCarga);
}
