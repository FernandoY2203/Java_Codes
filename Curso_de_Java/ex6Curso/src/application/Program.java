
package application;

import entities.Quarto;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        Quarto[] vet = new Quarto[10];
        
        System.out.print("Quantos quartos serão alugados? ");
        int qtd = sc.nextInt();
        sc.nextLine();
        System.out.println();
        
        for(int i = 1; i <= qtd; i++){
            System.out.println("Aluguel #" + i + ": ");
            System.out.print("Nome: ");
            String nome = sc.nextLine();
            System.out.print("Email: ");
            String email = sc.nextLine();
            System.out.print("Quarto: ");
            int numQuarto = sc.nextInt();
            sc.nextLine();
            
            vet[numQuarto] = new Quarto(nome, email, numQuarto);
            
            System.out.println();
        }
        
        System.out.println("Quartos Alugados: ");
        
        for(int j = 0; j < vet.length; j++){
            if(vet[j] != null){
                System.out.println(vet[j].toString());
            }
        }
    }
    
}
