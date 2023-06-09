
package application;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        System.out.println("Enter client data: ");
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Birth Date (DD/MM/YYYY): ");
        LocalDate birthDate = LocalDate.parse(sc.next(), fmt);
        
        System.out.println();
        
        System.out.println("Enter order data: ");
        System.out.print("Status: ");
        OrderStatus os = OrderStatus.valueOf(sc.next());
        
        Order order = new Order(LocalDateTime.now(), os, new Client(name, email, birthDate));
        
        System.out.print("How many items to this order? ");
        int n = sc.nextInt();
        
        System.out.println();
        
        for (int i = 1; i <= n; i++) {
            System.out.println("Enter #" + i + " item data: ");
            System.out.print("Product name: ");
            String pName = sc.next();
            sc.nextLine();
            System.out.print("Product price: ");
            double pPrice = sc.nextDouble();
            System.out.print("Quantity: ");
            int qtd = sc.nextInt();
            
            order.addItem(new OrderItem(qtd, pPrice, new Product(pName, pPrice)));
        }
        
        System.out.println();
        
        System.out.println("ORDER SUMMARY: ");
        System.out.println(order);
    }
}
