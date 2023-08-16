import java.util.*;

public class MonitoramentoLogsAWS {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int quantidadeLogs = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do scanner

        Map<String, Long> eventosPorServico = new HashMap<>();
        for (int i = 0; i < quantidadeLogs; i++) {
            String[] parts = scanner.nextLine().split(",");
            String servico = parts[1];
            
            //TODO: Utilize o mapa para registrar/incrementar o serviço em questão.
            if(eventosPorServico.containsKey(servico)){
                eventosPorServico.put(servico, eventosPorServico.get(servico) + 1L);
            }
            else{
                eventosPorServico.put(servico, 1L);
            }
        }

        //TODO: Identifique no mapa os serviços com maior e menor quantidade de logs.
        //      Dica: Utilize Java Streams para tornar essa tarefa mais simples.
        String maior = eventosPorServico.entrySet().stream().max((x1, x2) -> x1.getValue().compareTo(x2.getValue())).get().getKey();
        String menor = eventosPorServico.entrySet().stream().min((x1, x2) -> x1.getValue().compareTo(x2.getValue())).get().getKey();
        

        //TODO: Imprima a saída no padrão definido no enunciado deste desafio.
        System.out.println("Eventos por servico:");
        
        for (String k : eventosPorServico.keySet()) {
            System.out.println(k + ":" + eventosPorServico.get(k));
        }
        System.out.println("Maior:" + maior);
        System.out.println("Menor:" + menor);
    }
}