package com.gabrielmbarboza.sienge.exception;

public class KmRodadoNegativoException extends Exception {
    @Override
    public String getMessage() {
        return "A quilometragem não pode ser um valor negativo";
    }
}
