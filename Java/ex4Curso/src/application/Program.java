
package application;

import entities.ConversorDeCotacao;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Qual o Valor do Dolar? ");
        double valDolar = sc.nextDouble();
        System.out.print("Quantos Dolares serão comprados? ");
        double qtdDolar = sc.nextDouble();
        
        System.out.println("Quantidade a ser Paga em Reais = " + ConversorDeCotacao.precoAPagar(valDolar, qtdDolar));
        
        sc.close();
    }  
}
