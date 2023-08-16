package atv2CarrinhoDeCompras;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {
    
    private List<Item> itens;

    public CarrinhoDeCompras() {
        this.itens = new ArrayList<>();
    }
    
    public void adicionarItem(String nome, double preco, int qtd){
        itens.add(new Item(nome, preco, qtd));
    }
    
    public void removerItem(String nome){
        List<Item> auxList = new ArrayList<>();
        
        if(!itens.isEmpty()){
            for (Item i : itens) {
                if(i.getNome().equalsIgnoreCase(nome)){
                    auxList.add(i);
                }
            }
            
            itens.removeAll(auxList);
        }
        else{
            System.out.println("A lista está vazia!!");
        }
    }
    
    public double calcularValorTotal(){
        double aux = 0;
        
        for (Item i : itens) {
            aux += i.getPreco() * i.getQtd();
        }
        
        return aux;
    }
    
    public void exibirItens(){
        if(!itens.isEmpty()){
            for (Item i : itens) {
                System.out.println(i);
            }
        }
        else{
            System.out.println("A lista está vazia!!");
        }
    }
}
