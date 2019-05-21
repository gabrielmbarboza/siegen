package com.gabrielmbarboza.sienge.exception;

public class PesoCargaNegativoException extends Exception {
    @Override
    public String getMessage() {
        return "O peso da carga não pode ser um valor negativo";
    }
}
