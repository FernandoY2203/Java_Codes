package br.com.yuji.subsistemCRMTest;

// Classe Teste sem funcionalidade real.

public class CrmService {

    private CrmService() {
    }

    
    public static void gravarCliente(String nome, String cep, String cidade, String estado) {
        System.out.println("Cliente gravado no sistema");
        System.out.println("Nome: " + nome);
        System.out.println("CEP: " + cep);
        System.out.println("Cidade: " + cidade);
        System.out.println("Estado: " + estado);
    }
}
