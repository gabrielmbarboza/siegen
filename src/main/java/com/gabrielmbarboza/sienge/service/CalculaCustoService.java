package com.gabrielmbarboza.sienge.service;

import com.gabrielmbarboza.sienge.model.CustoTotalTransporte;
import com.gabrielmbarboza.sienge.model.TipoCaminhao;
import com.gabrielmbarboza.sienge.model.TipoVia;
import com.gabrielmbarboza.sienge.rules.RegraCalculoViaTerrestre;
import org.springframework.stereotype.Service;

@Service
public class CalculaCustoService {
    public CustoTotalTransporte calcularCusto(String tipoCaminhao, int kmPavimentada, int kmNaoPavimentada, int pesoCarga) {
        CustoTotalTransporte custoTotalTransporte = new CustoTotalTransporte();

        if(!tipoCaminhao.isEmpty()) {
            RegraCalculoViaTerrestre regraViaPavimentada = TipoVia.PAVIMENTADA.getRegraCalculoVia();
            RegraCalculoViaTerrestre regraViaNaoPavimentada = TipoVia.NAO_PAVIMENTADA.getRegraCalculoVia();

            TipoCaminhao caminhao = TipoCaminhao.valueOf(tipoCaminhao);

            Double custoViaPavimentada = regraViaPavimentada.calcularCustoTotal(caminhao, kmPavimentada, pesoCarga);
            Double custoViaNaoPavimentada = regraViaNaoPavimentada.calcularCustoTotal(caminhao, kmNaoPavimentada, pesoCarga);

            Double custoTotal = (custoViaPavimentada + custoViaNaoPavimentada);

            custoTotalTransporte.setTipoVeiculo(tipoCaminhao);
            custoTotalTransporte.setKmViaPavimentanda(kmPavimentada);
            custoTotalTransporte.setKmViaNaoPavimentanda(kmNaoPavimentada);
            custoTotalTransporte.setPesoCarga(pesoCarga);
            custoTotalTransporte.setCustoTotal(custoTotal);

        }

        return custoTotalTransporte;
    }
}
