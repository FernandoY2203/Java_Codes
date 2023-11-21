package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Entre com o caminho do Arquivo: ");
        File caminhoArquivo = new File(sc.nextLine());

        String caminhoPasta = caminhoArquivo.getParent();

        boolean sucesso = new File(caminhoPasta + "\\out").mkdir();

        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo)); BufferedWriter bw = new BufferedWriter(new FileWriter(caminhoPasta + "\\out\\summary.csv"))) {

            String linha = br.readLine();

            while (linha != null) {
                String[] vet = linha.split(",");

                String nome = vet[0];
                double preco = Double.parseDouble(vet[1]);
                int qtd = Integer.parseInt(vet[2]);

                bw.write(nome + ", " + String.format("%.2f", preco * qtd));
                bw.newLine();

                linha = br.readLine();
            }
        } catch (IOException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}