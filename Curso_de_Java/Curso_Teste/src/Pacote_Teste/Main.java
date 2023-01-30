package Pacote_Teste;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
				
	    char c = ' ';
        int num1, num2, result;

        do{
            System.out.print("Digite o primeiro numero a ser somado: ");
            num1 = sc.nextInt();

            System.out.print("Digite o segundo numero a ser somado: ");
            num2 = sc.nextInt();

            result = num1 + num2;

            System.out.println("O Resultado foi: " + result);

            System.out.println("Digite s para repetir a soma");
            c = sc.next().charAt(0);

        }while(c == 's' || c == 'S');

        sc.close();
    }
}
