package com.gabrielmbarboza.sienge.model;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class CustoTotalTransporte {
    private String tipoVeiculo;
    private int kmViaPavimentanda;
    private int kmViaNaoPavimentanda;
    private Double custoTotal = 0.0;
    private int pesoCarga;

    public CustoTotalTransporte() {}

    public CustoTotalTransporte(String tipoVeiculo, int kmViaPavimentanda,
                                int kmViaNaoPavimentanda, int pesoCarga, Double custoTotal) {
        this.tipoVeiculo = tipoVeiculo;
        this.kmViaPavimentanda = kmViaPavimentanda;
        this.kmViaNaoPavimentanda = kmViaNaoPavimentanda;
        this.pesoCarga = pesoCarga;
        this.custoTotal = custoTotal;
    }

    public String getTipoVeiculo() {
        return tipoVeiculo;
    }

    public void setTipoVeiculo(String tipoVeiculo) {
        this.tipoVeiculo = tipoVeiculo;
    }

    public int getKmViaPavimentanda() {
        return kmViaPavimentanda;
    }

    public void setKmViaPavimentanda(int kmViaPavimentanda) {
        this.kmViaPavimentanda = kmViaPavimentanda;
    }

    public int getKmViaNaoPavimentanda() {
        return kmViaNaoPavimentanda;
    }

    public void setKmViaNaoPavimentanda(int kmViaNaoPavimentanda) {
        this.kmViaNaoPavimentanda = kmViaNaoPavimentanda;
    }

    public String getCustoTotal() {
        return String.format("%.2f", custoTotal);
    }

    public void setCustoTotal(Double custoTotal) {
        this.custoTotal = custoTotal;
    }

    public int getPesoCarga() {
        return pesoCarga;
    }

    public void setPesoCarga(int pesoCarga) {
        this.pesoCarga = pesoCarga;
    }
}
