
package application;

import entities.Product;
import java.util.Scanner;

public class Program {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Digite os dados do produto: ");
        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("Preço: ");
        double preco = sc.nextDouble();
        
        Product prd1 = new Product(nome, preco);
        
        System.out.println("Informação do Produto: " + prd1.toString());

        System.out.print("Entre com o numero de produtos a serem adicionados no estoque: ");
        prd1.AdicionarProdutos(sc.nextInt());

        System.out.println("Informação Atualizada: " + prd1.toString());

        System.out.print("Entre com o numero de produtos a serem removidos do estoque: ");
        prd1.RemoverProdutos(sc.nextInt());

        System.out.println("Informação Atualizada: " + prd1.toString());

        sc.close();
    }
}
