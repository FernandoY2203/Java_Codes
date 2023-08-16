import java.util.Scanner;

public class RegrasEKS {
    public static void main(String[] args) {
        // Definindo as regras básicas
        double podsPorNode = 10;
        double podsPorServidor = 4;

        // Criando um objeto Scanner para receber as entradas do usuário
        Scanner scanner = new Scanner(System.in);

        // Recebendo as informações do usuário
        int numeroTotalPods = scanner.nextInt();

        //TODO: Calcule o número mínimo de nodes necessários
        long numeroMinimoNodes = Math.round(numeroTotalPods / podsPorNode);

        //TODO: Calcule o número mínimo de servidores necessários
        long numeroMinimoServidores = Math.round(numeroTotalPods / podsPorServidor);

        //TODO: Exiba o resultado com as recomendações de quantidades de servidores e nodes.
        if(numeroMinimoNodes <= 1){
            System.out.println("1.Recomendamos usar um unico node");
            System.out.println("2.Numero minimo de servidores:" + numeroMinimoServidores);
        }
        else if(numeroMinimoServidores <= 1){
            System.out.println("1.Numero minimo de nodes:" + numeroMinimoNodes);
            System.out.println("2.Recomendamos usar um unico servidor");
        }
        else{
            System.out.println("1.Numero minimo de nodes:" + numeroMinimoNodes);
            System.out.println("2.Numero minimo de servidores:" + numeroMinimoServidores);
        }

        // Fechando o Scanner
        scanner.close();
    }
}
