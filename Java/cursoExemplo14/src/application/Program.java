package application;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Program {

    public static void main(String[] args) {

        //Stream
        List<Integer> list = Arrays.asList(3, 4, 5, 10, 7);
        Stream<Integer> st1 = list.stream();
        System.out.println(Arrays.toString(st1.toArray()));
        
        Stream<String> st2 = Stream.of("Maria", "Alex", "Bob");
        System.out.println(Arrays.toString(st2.toArray()));
        
        Stream<Integer> st3 = Stream.iterate(0, x -> x + 2);
        System.out.println(Arrays.toString(st3.limit(10).toArray()));
        
        Stream<Long> st4 = Stream.iterate(new long[]{0L, 1L}, p -> new long[]{p[1], p[0] + p[1]}).map(p -> p[0]);
        System.out.println(Arrays.toString(st4.limit(100).toArray()));
        

        //Pipeline
        List<Integer> list2 = Arrays.asList(3, 4, 5, 10, 7);
        Stream<Integer> st5 = list2.stream().map(x -> x * 10);
        System.out.println(Arrays.toString(st5.toArray()));
        
        int sum = list2.stream().reduce(0, (x, y) -> x + y); // Recebe uma valor inicial, x é o valor acumulador e y é o combinador
        System.out.println("Sum = " + sum);
        
        List<Integer> newList = list2.stream().filter(x -> x % 2 == 0).map(x -> x * 10).collect(Collectors.toList()); // Filtra a Stream
        System.out.println(Arrays.toString(newList.toArray()));
    }
}
