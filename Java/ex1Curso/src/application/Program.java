
package application;

import entities.Rectangle;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        Rectangle ret = new Rectangle();
        
        System.out.println("Digite a Largura e a Altura do retangulo: ");
        ret.largura = sc.nextDouble();
        ret.altura = sc.nextDouble();
        
        System.out.print("Area " + ret.Area() + "\n");
        System.out.print("Perimetro: " + ret.Perimetro() + "\n");
        System.out.print("Diagonal: " + String.format("%.2f", ret.Diagonal()));
        
        sc.close();
    }
    
}
