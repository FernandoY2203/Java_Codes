package br.com.yuji.strategy;

// Concrete Strategy 2

public class ComportamentoDefensivo implements Comportamento{

    @Override
    public void mover() {
        System.out.println("Defendendo...");
    }
    
}
