package application;

import java.util.InputMismatchException;
import java.util.Scanner;
import xadrez.ExcecaoDoXadrez;
import xadrez.PartidaDeXadrez;
import xadrez.PecaDeXadrez;
import xadrez.PosicaoNoXadrez;

public class Program {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        PartidaDeXadrez partida = new PartidaDeXadrez();

        while (true) {
            try {
                UI.limparTela();
                UI.imprimirPartida(partida);

                System.out.println();

                System.out.print("Origem: ");
                PosicaoNoXadrez origem = UI.lendoPosicaoNoXadrez(sc);
                
                System.out.println();
                
                boolean[][] movimentosPossiveis = partida.movimentosPossiveis(origem);
                
                UI.limparTela();
                UI.imprimiTabuleiro(partida.getPecas(), movimentosPossiveis);

                System.out.println();

                System.out.print("Alvo: ");
                PosicaoNoXadrez alvo = UI.lendoPosicaoNoXadrez(sc);
                
                System.out.println();

                PecaDeXadrez pecaCapturada = partida.executarOMovimentoDeXadrez(origem, alvo);
            }
            catch(ExcecaoDoXadrez e){
                System.out.println(e.getMessage());
                
                sc.nextLine();
            }
            catch(InputMismatchException e){
                System.out.println(e.getMessage());
                
                sc.nextLine();
            }
        }

    }

}
