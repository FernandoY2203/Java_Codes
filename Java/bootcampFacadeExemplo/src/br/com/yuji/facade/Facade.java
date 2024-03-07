package br.com.yuji.facade;

// Fachada

import br.com.yuji.subsistemCEPTest.CepApi;
import br.com.yuji.subsistemCRMTest.CrmService;

public class Facade {
    
    public void migrarCliente(String nome, String cep) {
        CepApi inst = CepApi.getInstance();
        
        CrmService.gravarCliente(nome, cep, inst.recuperarCidade(cep), inst.recuperarEstado(cep));
    }
}
