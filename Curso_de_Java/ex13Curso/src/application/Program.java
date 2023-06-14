
package application;

import entities.Pessoa;
import entities.PessoaFisica;
import entities.PessoaJuridica;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US); // Cuidado ao usar "," no lugar de "."
        Scanner sc = new Scanner(System.in); 
        
        List<Pessoa> pessoas = new ArrayList<>();
        
        System.out.print("Enter the number of tax payers: ");
        int n = sc.nextInt();
        
        System.out.println();
        
        for (int i = 1; i <= n; i++) {
            System.out.println("Tax payer #" + i + " data: ");
            System.out.print("Individual or company (i/c)? ");
            char c = sc.next().charAt(0);
            sc.nextLine();
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Anual income: ");
            double income = sc.nextDouble();
            
            switch(c){
                case 'i':
                    System.out.print("Health expenditures: ");
                    double hExpend = sc.nextDouble();
                    
                    pessoas.add(new PessoaFisica(hExpend, name, income));
                break;
                case 'c':
                    System.out.print("Number of employees: ");
                    int numFunc = sc.nextInt();
                    
                    pessoas.add(new PessoaJuridica(numFunc, name, income));
                break;
            }
        }
        
        System.out.println();
        
        double aux = 0;
        
        System.out.println("TAXES PAID: ");
        for (Pessoa p : pessoas) {
            aux += p.imposto();
            
            System.out.println(p);
        }
        
        System.out.println();
        
        System.out.println("TOTAL TAXES: $" + String.format("%.2f", aux));
        
        sc.close();
    }
    
}
