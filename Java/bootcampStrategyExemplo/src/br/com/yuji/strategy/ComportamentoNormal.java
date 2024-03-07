package br.com.yuji.strategy;

// Concrete Strategy 1

public class ComportamentoNormal implements Comportamento{

    @Override
    public void mover() {
        System.out.println("Movendo Normalmente...");
    }
    
}
