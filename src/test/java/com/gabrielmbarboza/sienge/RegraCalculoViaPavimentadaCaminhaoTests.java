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
public class RegraCalculoViaPavimentadaCaminhaoTests {
    RegraCalculoViaTerrestre regraCalculoVia = TipoVia.PAVIMENTADA.getRegraCalculoVia();

    @Test
    public void calcularCustoTotalTest() {
        Double expected = 62.70;
        Assert.assertEquals(expected, regraCalculoVia.calcularCustoTotal(TipoCaminhao.CACAMBA,100, 8));
    }

    @Test
    public void calcularCustoKmRodadoTest() {
        Double expected = 54.0;
        try {
            Assert.assertEquals(expected, regraCalculoVia.calcularCustoKmRodado(100));
        } catch (KmRodadoNegativoException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void calcularPesoExcedenteTest() {
        Double expected = 6.00;

        try {
            Assert.assertEquals(expected, regraCalculoVia.calcularPesoExcedente(100, 8));
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
