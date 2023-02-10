
package application;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Digite o Valor de M e N: ");
        int m = sc.nextInt();
        int n = sc.nextInt();
        
        int[][] mat = new int[m][n];
        
        System.out.println();
        
        System.out.println("Digite os Valores da Matriz: ");
        for(int l = 0; l < m; l++){
            for(int c = 0; c < n; c++){
                mat[l][c] = sc.nextInt();
            }
        }
        
        System.out.println();
        
        System.out.print("Digite o Valor de X: ");
        int x = sc.nextInt();
        
        System.out.println();
        
        for(int l = 0; l < m; l++){
            for(int c = 0; c < n; c++){
                if(mat[l][c] == x){
                    System.out.println("Posição " + l + "," + c + ":");
                    
                    if(l > 0){
                        System.out.println("Cima: " + mat[l - 1][c]);
                    }
                    if(c > 0){
                        System.out.println("Esquerda: " + mat[l][c - 1]);
                    }
                    if(l < mat.length - 1){
                        System.out.println("Baixo: " + mat[l + 1][c]); 
                    }
                    if(c < mat[l].length - 1){
                        System.out.println("Direita: " + mat[l][c + 1]);
                    }
                    
                    System.out.println();
                }
            }
        }
        
        sc.close();
    }  
}
