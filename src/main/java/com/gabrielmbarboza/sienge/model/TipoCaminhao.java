package com.gabrielmbarboza.sienge.model;

import com.gabrielmbarboza.sienge.rules.RegraCalculoVeiculo;
import com.gabrielmbarboza.sienge.rules.RegraCalculoVeiculoCaminhaoBau;
import com.gabrielmbarboza.sienge.rules.RegraCalculoVeiculoCaminhaoCacamba;
import com.gabrielmbarboza.sienge.rules.RegraCalculoVeiculoCarreta;

public enum TipoCaminhao {
    BAU(new RegraCalculoVeiculoCaminhaoBau()),
    CACAMBA(new RegraCalculoVeiculoCaminhaoCacamba()),
    CARRETA(new RegraCalculoVeiculoCarreta());

    private RegraCalculoVeiculo regraCalculoVeiculo;

    TipoCaminhao(RegraCalculoVeiculo regraCalculoVeiculo){
        this.regraCalculoVeiculo = regraCalculoVeiculo;
    }

    public RegraCalculoVeiculo getRegraCalculoVeiculo() {
        return regraCalculoVeiculo;
    }
}
