
package application;

import entities.Product;
import java.util.Scanner;

public class Program {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        Product prd1 = new Product();
        
        System.out.println("Digite os dados do produto: ");
        System.out.print("Nome: ");
        prd1.nome = sc.nextLine();
        System.out.print("Preço: ");
        prd1.preco = sc.nextDouble();
        System.out.print("Quantidade em Estoque: ");
        prd1.qtd = sc.nextInt();
        
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
