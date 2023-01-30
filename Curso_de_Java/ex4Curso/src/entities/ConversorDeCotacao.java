
package entities;

public class ConversorDeCotacao {
    public static final double IOF = 0.06;
    
    public static double precoAPagar(double valDolar, double qtdDolar){
        double aux;
        
        aux = qtdDolar + (1 + IOF);
        
        return aux * valDolar;
    }
}
