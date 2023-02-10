
package application;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Digite o valor de N: ");
        int n = sc.nextInt();
        
        System.out.println();
        
        int[][] mat = new int[n][n];
        
        int aux = 0;
        
        for(int l = 0; l < mat.length; l++){
            for(int c = 0; c < mat[l].length; c++){
                mat[l][c] = sc.nextInt();
                
                if(mat[l][c] < 0){
                    aux++;
                }
            }
        }
        
        System.out.println();
        
        System.out.println("Diagonal Principal: ");
        
        for(int i = 0; i < mat.length; i++){
            System.out.print(mat[i][i] + " ");
        }
        
        System.out.println();
        
        System.out.println("Numeros Negativos: " + aux);
        
        sc.close();
    }
}
