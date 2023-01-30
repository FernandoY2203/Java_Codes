
package application;

import entities.Aluno;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        Aluno al = new Aluno();
        
        System.out.println("Digite o Nome do Aluno e as Notas dos tres Trimestres: ");
        al.nome = sc.nextLine();
        al.nota1 = sc.nextDouble();
        al.nota2 = sc.nextDouble();
        al.nota3 = sc.nextDouble();
        
        System.out.println(al.toString());
        
        sc.close();
    }
    
}
