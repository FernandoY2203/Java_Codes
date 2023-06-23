package application;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import xadrez.ExcecaoDoXadrez;
import xadrez.PartidaDeXadrez;
import xadrez.PecaDeXadrez;
import xadrez.PosicaoNoXadrez;

public class Program {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        PartidaDeXadrez partida = new PartidaDeXadrez();
        List<PecaDeXadrez> capturada = new ArrayList<>();

        while (!partida.getXequeMate()) {
            try {
                UI.limparTela();
                UI.imprimirPartida(partida, capturada);

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
                
                if(pecaCapturada != null){
                    capturada.add(pecaCapturada);
                }
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
        
        UI.limparTela();
        UI.imprimirPartida(partida, capturada);
    }

}
