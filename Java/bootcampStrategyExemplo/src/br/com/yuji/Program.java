package br.com.yuji;

import br.com.yuji.strategy.Comportamento;
import br.com.yuji.strategy.ComportamentoAgressivo;
import br.com.yuji.strategy.ComportamentoDefensivo;
import br.com.yuji.strategy.ComportamentoNormal;
import br.com.yuji.strategy.Robo;

public class Program {
    public static void main(String[] args) {
        
        // Strategy Tests
        Comportamento normal = new ComportamentoNormal();
        Comportamento defensivo = new ComportamentoDefensivo();
        Comportamento agressivo = new ComportamentoAgressivo();
        
        Robo rob = new Robo();
        rob.setStrategy(normal);
        rob.mover();
        
        System.out.println();
        
        rob.setStrategy(defensivo);
        rob.mover();
        
        System.out.println();
        
        rob.setStrategy(agressivo);
        rob.mover();
    }
    
}
