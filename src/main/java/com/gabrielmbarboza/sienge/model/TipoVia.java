package com.gabrielmbarboza.sienge.model;

import com.gabrielmbarboza.sienge.rules.RegraCalculoViaNaoPavimentadaCaminhao;
import com.gabrielmbarboza.sienge.rules.RegraCalculoViaPavimentadaCaminhao;
import com.gabrielmbarboza.sienge.rules.RegraCalculoViaTerrestre;

public enum TipoVia {
    PAVIMENTADA(new RegraCalculoViaPavimentadaCaminhao()),
    NAO_PAVIMENTADA(new RegraCalculoViaNaoPavimentadaCaminhao());

    private RegraCalculoViaTerrestre regraCalculoVia;

    TipoVia(RegraCalculoViaTerrestre regraCalculoVia) {
        this.regraCalculoVia = regraCalculoVia;
    }

    public RegraCalculoViaTerrestre getRegraCalculoVia() {
        return regraCalculoVia;
    }
}
