package application;

import device.Iphone;

public class Program {
    public static void main(String[] args) {
        
        Iphone cel = new Iphone(true, 50);
        
        //Verificando os Atributos
        System.out.println("Internet: " + cel.getInternet());
        System.out.println("Sinal: " + cel.getSinalDeRede());
        System.out.println("Bateria: " + cel.getPorcentBateria());
        System.out.println("Volume: " + cel.getVolume());
        System.out.println("RAM: " + cel.getMemoriaRAM());
        System.out.println();
        
        
        // Ligando a Internet
        cel.ligarInternet();
        System.out.println(cel.getInternet());
        System.out.println();
        
//        // Desligando a Internet
//        cel.desligarInternet();
//        System.out.println(cel.getInternet());
//        System.out.println();
        
        // Aumentando Volume
        cel.aumentarVolume();
        System.out.println(cel.getVolume());
        System.out.println();
        
        // Diminuindo Volume
        cel.diminuirVolume();
        System.out.println(cel.getVolume());
        System.out.println("\n");
        
        
        // Aparelho Telefônico
        // Ligar
        cel.ligar("996115909");
        System.out.println();
        
        // Atender
        cel.atender();
        System.out.println();
        
        // Iniciar Correio de Voz
        cel.iniciarCorreioVoz();
        System.out.println();
        
        // Desligar Chamada
        cel.desligarChamada();
        System.out.println("\n");
        
        
        // Reprodutor de Música
        // Tocar
        cel.tocar();
        System.out.println();
        
        // Pausar
        cel.pausar();
        System.out.println();
        
        // Selecionar Música
        cel.selecionarMusica("Ode á Nudez");
        System.out.println("\n");
        
        
        // Navegador de Internet
        // Exibir Página
        cel.exibirPagina("www.youtube.com");
        System.out.println("RAM: " + cel.getMemoriaRAM());
        System.out.println();
        
        // Adicionar Nova Aba
        cel.adicionarNovaAba();
        System.out.println("RAM: " + cel.getMemoriaRAM());
        System.out.println();
        
        // Atualizar Página
        cel.atualizarPagina();
        System.out.println();
        
        // Fechar Aba
        cel.fecharAba();
        //cel.fecharAba();
        System.out.println("RAM: " + cel.getMemoriaRAM());
    }
}
