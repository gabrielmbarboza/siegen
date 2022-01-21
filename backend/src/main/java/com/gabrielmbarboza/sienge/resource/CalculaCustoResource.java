package com.gabrielmbarboza.sienge.resource;


import com.gabrielmbarboza.sienge.model.CustoTotalTransporte;
import com.gabrielmbarboza.sienge.service.CalculaCustoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculaCustoResource {

    @Autowired
    CalculaCustoService calculaCusto;

    @CrossOrigin
    @RequestMapping("/calcular")
    public ResponseEntity<CustoTotalTransporte> calcular(
            @RequestParam(value="tipo_caminhao") String tipoCaminhao,
            @RequestParam(value="km_pavimentada", required = false) int kmPavimentada,
            @RequestParam(value="km_nao_pavimentada", required = false) int kmNaoPavimentada,
            @RequestParam(value="peso_carga") int pesoCarga) {
        CustoTotalTransporte custoTotalTransporte = calculaCusto.calcularCusto(tipoCaminhao, kmPavimentada, kmNaoPavimentada, pesoCarga);

        return new ResponseEntity<CustoTotalTransporte>(custoTotalTransporte, HttpStatus.CREATED);
    }
}
