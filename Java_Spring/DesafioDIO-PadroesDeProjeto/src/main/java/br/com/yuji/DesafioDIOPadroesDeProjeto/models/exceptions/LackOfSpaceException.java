package br.com.yuji.DesafioDIOPadroesDeProjeto.models.exceptions;

import java.io.Serial;

public class LackOfSpaceException extends RuntimeException{

    @Serial
    private static final long serialVersionUID = 1L;

    public LackOfSpaceException(String message) {
        super(message);
    }
}
