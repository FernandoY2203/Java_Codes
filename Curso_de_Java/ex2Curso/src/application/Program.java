
package application;

import entities.Employee;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        Employee emp = new Employee();
        
        System.out.println("Digite as informações do empregado: ");        
        System.out.print("Nome: ");
        emp.nome = sc.nextLine();
        System.out.print("Salario Bruto: ");        
        emp.salarioBruto = sc.nextDouble();
        System.out.print("Imposto: "); 
        emp.imposto = sc.nextDouble();
        
        System.out.println("Empregado: " + emp.toString()); 
        System.out.print("Qual a porcentagem de aumento no salario? ");
        emp.aumentarSalario(sc.nextDouble());
        System.out.println("Dados atualizados: " + emp.toString()); 
        
        sc.close();
    }
    
}
