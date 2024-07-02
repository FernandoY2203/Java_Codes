package br.com.yuji.DesafioDIO_BancoDigitalOrientadoAObjetos.models.exceptions;

public class AccountNotExistException extends RuntimeException {

    public AccountNotExistException() {
        super("Conta Inexistente...");
    }
}
