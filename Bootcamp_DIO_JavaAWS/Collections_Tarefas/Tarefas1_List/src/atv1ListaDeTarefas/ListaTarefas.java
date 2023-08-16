package atv1ListaDeTarefas;

import java.util.ArrayList;
import java.util.List;

public class ListaTarefas {

    private List<Tarefa> listaDeTarefas;

    public ListaTarefas() {
        this.listaDeTarefas = new ArrayList<>();
    }

    public void adicionarTarefa(String descricao) {
        listaDeTarefas.add(new Tarefa(descricao));
    }

    public void removerTarefa(String descricao) {
        List<Tarefa> auxList = new ArrayList<>();
        
        if (!listaDeTarefas.isEmpty()) {
            for (Tarefa ldt : listaDeTarefas) {
                if (ldt.getDescricao().equalsIgnoreCase(descricao)) {
                    auxList.add(ldt);
                }
            }
            
            listaDeTarefas.removeAll(auxList);
        } 
        else {
            System.out.println("A lista está vazia!!");
        }
    }

    public Integer obterNumeroTotalTarefas() {
        return listaDeTarefas.size();
    }

    public void obterDescricoesTarefas() {
        if (!listaDeTarefas.isEmpty()) {
            for (Tarefa lts : listaDeTarefas) {
                System.out.println(lts);
            }
        } else {
            System.out.println("A lista está vazia!!");
        }
    }
}
