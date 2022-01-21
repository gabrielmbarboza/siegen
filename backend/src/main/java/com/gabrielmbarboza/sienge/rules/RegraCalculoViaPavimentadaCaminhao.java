package com.gabrielmbarboza.sienge.rules;

import com.gabrielmbarboza.sienge.exception.KmRodadoNegativoException;
import com.gabrielmbarboza.sienge.exception.PesoCargaNegativoException;
import com.gabrielmbarboza.sienge.model.TipoCaminhao;

public class RegraCalculoViaPavimentadaCaminhao implements RegraCalculoViaTerrestre {
    private final int limitePesoCarga = 5;
    private final Double custoKmRodado = 0.54;
    private final Double custoPesoExcedente = 0.02;

    public Double calcularCustoTotal(TipoCaminhao tipoCaminhao, int kmRodado, int pesoCarga) {
        Double custoTotal = 0.0;
        RegraCalculoVeiculo regraCalculoVeiculo = tipoCaminhao.getRegraCalculoVeiculo();

        try {
            custoTotal = calcularCustoKmRodado(kmRodado);
            custoTotal = regraCalculoVeiculo.calcularCustoTotal(custoTotal);
            if (isPesoExcedente(pesoCarga)) {
                custoTotal += (calcularPesoExcedente(kmRodado, pesoCarga));
            }

        } catch (PesoCargaNegativoException p) {
            System.out.println(p.getMessage());
        } catch (KmRodadoNegativoException k) {
            System.out.println(k.getMessage());
        }

        return custoTotal;
    }

    public Double calcularCustoKmRodado(int kmRodado) throws KmRodadoNegativoException {
        Double custoKmRodadoTotal = 0.0;

        if(kmRodado >= 0) {
            custoKmRodadoTotal = custoKmRodado * kmRodado;
        } else {
            throw new KmRodadoNegativoException();
        }

        return custoKmRodadoTotal;
    }

    public Double calcularPesoExcedente(int kmRodado, int pesoCarga) throws PesoCargaNegativoException {
        int pesoExcedente = 0;
        Double custoPesoExcedenteTotal = 0.0;

        if(pesoCarga >= 0) {
            if(pesoCarga > limitePesoCarga) {
                pesoExcedente = pesoCarga - limitePesoCarga;
                custoPesoExcedenteTotal = (custoPesoExcedente * pesoExcedente) * kmRodado;
            }
        } else {
            throw new PesoCargaNegativoException();
        }

        return custoPesoExcedenteTotal;
    }

    public Boolean isPesoExcedente(int pesoCarga) {
        return pesoCarga > limitePesoCarga ? true : false;
    }
}
