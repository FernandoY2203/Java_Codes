
package application;

import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Escolha quantas alturas serão Digitado: ");
        int qtd = sc.nextInt();
        
        double[] vet = new double[qtd];
        
        for(int i = 0; i < qtd; i++){
            System.out.println("Digite a " + (i + 1) + " Altura");
            vet[i] = sc.nextDouble();
        }
        
        double aux = 0.0;
        
        for(int j = 0; j < qtd; j++){
            aux += vet[j];
        }
        
        double media = aux / qtd;
        
        System.out.println("Altura Média: " + String.format("%.2f", media));
        
        sc.close();
    }  
}
