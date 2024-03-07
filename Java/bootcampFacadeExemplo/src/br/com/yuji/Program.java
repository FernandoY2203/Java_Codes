package br.com.yuji;

import br.com.yuji.facade.Facade;

public class Program {
    public static void main(String[] args) {
        
        // Facade Tests
        Facade facade = new Facade();
        facade.migrarCliente("Vitor Augusto", "13590-000");
    }
    
}
