package br.com.yuji.DesafioDIO_BancoDigitalOrientadoAObjetos.models.exceptions;

public class InsufficientFundsException extends RuntimeException {

    public InsufficientFundsException(String message) {
        super("Saldo Insuficiente para realizar a operação: " + message);
    }
}
