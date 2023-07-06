package application;

import entities.Employee;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter full file path: ");
        String path = sc.nextLine();
        
        System.out.println();
        
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            List<Employee> list = new ArrayList<>();
            
            String line = br.readLine();
            
            while(line != null){
                String[] vet = line.split(",");
                
                list.add(new Employee(vet[0], vet[1], Double.parseDouble(vet[2])));
                
                line = br.readLine();
            }
            
            System.out.print("Enter salary: ");
            double infoSal = sc.nextDouble();
            
            List<String> emailList = list.stream().filter(s -> s.getSalary() > infoSal).map(e -> e.getEmail()).sorted().collect(Collectors.toList());
            
            System.out.println("Email of people whose salary is more than " + String.format("%.2f", infoSal) + ":");
            emailList.forEach(System.out::println);
            
            System.out.println();

            double sum = list.stream().filter(n -> n.getName().charAt(0) == 'M').map(s -> s.getSalary()).reduce(0.0, (x, y) -> x + y);
            
            System.out.print("Sum of salary of people whose name starts with 'M': " + String.format("%.2f", sum));
            
        } 
        catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}
