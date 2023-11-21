
package application;

import entities.Funcionario;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        List<Funcionario> list = new ArrayList<>();
        
        System.out.print("Quantos Funcionarios serão registrados: ");
        int qtd = sc.nextInt();
        
        System.out.println();
        
        for(int i = 0; i < qtd; i++){
            System.out.println("Funcionario #" + (i + 1));
            System.out.print("ID: ");
            int id = sc.nextInt();
            while(existeId(list, id)){
                System.out.print("Este Id já Existe, Escolha Outro: ");
		id = sc.nextInt();
            }
            sc.nextLine();
            System.out.print("Nome: ");
            String nome = sc.nextLine();
            System.out.print("Salario: ");
            double salario = sc.nextDouble();
            
            list.add(new Funcionario(id, nome, salario));
            
            System.out.println();
        }
        
        System.out.print("Digite o ID do Funcionario que irá receber um aumento: ");
        int idProcura = sc.nextInt();  
        
        if(existeId(list, idProcura)){
            Funcionario funcAux = list.stream().filter(x -> x.getId() == idProcura).findFirst().orElse(null);
            
            System.out.print("Digite a Porcentagem: ");
            funcAux.aumentoSalario(sc.nextDouble());
        }
        else{
            System.out.println("Esse ID Não Existe!!");
        }
        
        System.out.println();
        
        System.out.println("Lista de Funcionarios:");
        
        for(Funcionario x : list){
            System.out.println(x.toString());
        }
        
        sc.close();
    }
    
    public static boolean existeId(List<Funcionario> list, int id) {
        Funcionario func = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
	
        return func != null;
    }
}
