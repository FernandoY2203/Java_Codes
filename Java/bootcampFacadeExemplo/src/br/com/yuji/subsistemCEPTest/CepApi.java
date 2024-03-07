package br.com.yuji.subsistemCEPTest;

// Classe Teste sem funcionalidade real.

public class CepApi {

    private static CepApi instance = new CepApi();

    
    private CepApi() {
    }

    
    public static CepApi getInstance() {
        return instance;
    }
    
    public String recuperarCidade(String cep) {
        return "Dourado";
    }
    
    public String recuperarEstado(String cep) {
        return "SP";
    }
}
