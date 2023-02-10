
package application;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Program {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        
        list.add("Mario");
        list.add("Lucas");
        list.add("Ana");
        list.add("Laura");
        list.add("Maria");
        
        list.add(2, "Marco");
        
        for(String x : list){
            System.out.println(x);
        }
        
        System.out.println();
        
        System.out.println(list.size());
        
        System.out.println();
        
        list.remove("Ana");
        list.remove(1);
        list.removeIf(x -> x.charAt(0) == 'M');
        
        for(String x : list){
            System.out.println(x);
        }
        
        System.out.println();
        
        System.out.println(list.indexOf("Laura"));
        System.out.println(list.indexOf("Fernando"));
        
        System.out.println();
        
        List<String> result = list.stream().filter(x -> x.charAt(0) == 'L').collect(Collectors.toList());
        
        for(String y : result){
            System.out.println(y);
        }
        
        System.out.println();
        
        String name = list.stream().filter(x -> x.charAt(0) == 'L').findFirst().orElse(null);
        
        System.out.println(name);
    }
}
