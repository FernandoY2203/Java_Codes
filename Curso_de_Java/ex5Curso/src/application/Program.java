
package application;

import entities.Conta;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        Conta c;
        
        System.out.print("Numero da Conta: ");
        int numConta = sc.nextInt();
        sc.nextLine();
        System.out.print("Nome do Titular da Conta: ");
        String nomeConta = sc.nextLine();
        System.out.print("Deseja fazer um Deposito inicial (S/N)? ");
        char escolha = sc.next().charAt(0);
        sc.nextLine();
        

        
        if(escolha == 'S' || escolha == 's'){
            System.out.print("Digite o Valor do Deposito Inicial: ");
            double deposito = sc.nextDouble();
            
            c = new Conta(numConta, nomeConta, deposito);
        }
        else{
            c = new Conta(numConta, nomeConta);
        }
        
        System.out.println();
        System.out.println("Informaçoes da Conta: ");
        System.out.println(c.toString());
        
        System.out.println();
        System.out.print("Digite o Valor do Deposito: ");
        c.deposito(sc.nextDouble());
        System.out.println(c.toString());
        
        System.out.println();
        System.out.print("Entre com o Valor a ser Sacado: ");
        c.saque(sc.nextDouble());
        System.out.println(c.toString());
        
        sc.close();
    }
    
}
