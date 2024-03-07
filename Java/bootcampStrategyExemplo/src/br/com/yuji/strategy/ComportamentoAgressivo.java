package br.com.yuji.strategy;

// Concrete Strategy 3

public class ComportamentoAgressivo implements Comportamento{

    @Override
    public void mover() {
        System.out.println("Atacando...");
    }
    
}
