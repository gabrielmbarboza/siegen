package com.gabrielmbarboza.sienge;

import com.gabrielmbarboza.sienge.exception.KmRodadoNegativoException;
import com.gabrielmbarboza.sienge.exception.PesoCargaNegativoException;
import com.gabrielmbarboza.sienge.model.TipoCaminhao;
import com.gabrielmbarboza.sienge.model.TipoVia;
import com.gabrielmbarboza.sienge.rules.RegraCalculoViaTerrestre;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RegraCalculoViaNaoPavimentadaCaminhaoTests {
    RegraCalculoViaTerrestre regraCalculoVia = TipoVia.NAO_PAVIMENTADA.getRegraCalculoVia();

    @Test
    public void calcularCustoTotalTest() {
        Double expected = 37.20;
        Assert.assertEquals(expected, regraCalculoVia.calcularCustoTotal(TipoCaminhao.BAU,60, 4));
    }

    @Test
    public void calcularCustoKmRodadoTest() {
        Double expected = 37.20;
        try {
            Assert.assertEquals(expected, regraCalculoVia.calcularCustoKmRodado(60));
        } catch (KmRodadoNegativoException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void calcularPesoExcedenteTest() {
        Double expected = 0.0;

        try {
            Assert.assertEquals(expected, regraCalculoVia.calcularPesoExcedente(60, 4));
        } catch (PesoCargaNegativoException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void isPesoNaoExcedenteTest() {
        Assert.assertFalse(regraCalculoVia.isPesoExcedente(4));
    }

    @Test
    public void isPesoExcedenteTest() {
        Assert.assertTrue(regraCalculoVia.isPesoExcedente(8));
    }
}
