package com.gabrielmbarboza.sienge;

import com.gabrielmbarboza.sienge.model.CustoTotalTransporte;
import com.gabrielmbarboza.sienge.model.TipoCaminhao;
import com.gabrielmbarboza.sienge.service.CalculaCustoService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.assertj.AssertableApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CalculoCustoServiceTest {

    @Autowired
    CalculaCustoService calculaCustoService;

    @Test
    public void calculaCustoViaPavimentaCaminhaoCacambaTest() {
        String expected = "62.70";
        CustoTotalTransporte custoTotalTransporte = calculaCustoService.calcularCusto("CACAMBA", 100, 0, 8);
        Assert.assertEquals(expected, custoTotalTransporte.getCustoTotal());
    }

    @Test
    public void calculaCustoViaNaoPavimentaCaminhaoBauTest() {
        String expected = "37.20";
        CustoTotalTransporte custoTotalTransporte = calculaCustoService.calcularCusto("BAU", 0, 60, 4);
        Assert.assertEquals(expected, custoTotalTransporte.getCustoTotal());
    }

    @Test
    public void calculaCustoViaNaoPavimentaCaminhaoCarretaTest() {
        String expected = "150.19";
        CustoTotalTransporte custoTotalTransporte = calculaCustoService.calcularCusto("CARRETA", 0, 180, 12);
        Assert.assertEquals(expected, custoTotalTransporte.getCustoTotal());
    }

    @Test
    public void calculaCustoViaNaoEPavimentaCaminhaoBauTest() {
        String expected = "57.60";
        CustoTotalTransporte custoTotalTransporte = calculaCustoService.calcularCusto("BAU", 80, 20, 6);
        Assert.assertEquals(expected, custoTotalTransporte.getCustoTotal());
    }

    @Test
    public void calculaCustoViaNaoEPavimentaCaminhaoCacambaTest() {
        String expected = "47.88";
        CustoTotalTransporte custoTotalTransporte = calculaCustoService.calcularCusto("CACAMBA", 50, 30, 5);
        Assert.assertEquals(expected, custoTotalTransporte.getCustoTotal());
    }

    @Test
    public void whenCalculaCustoSemVia_thenReturnCustoTotalTransporteVazio() {
        int expected1 = 0;
        String expected2 = "0.00";

        CustoTotalTransporte custoTotalTransporte = calculaCustoService.calcularCusto("", 50, 30, 5);
        Assert.assertNull(custoTotalTransporte.getTipoVeiculo());
        Assert.assertEquals(expected1, custoTotalTransporte.getKmViaPavimentanda());
        Assert.assertEquals(expected1, custoTotalTransporte.getKmViaNaoPavimentanda());
        Assert.assertEquals(expected2, custoTotalTransporte.getCustoTotal());
        Assert.assertEquals(expected1, custoTotalTransporte.getPesoCarga());
    }
}
