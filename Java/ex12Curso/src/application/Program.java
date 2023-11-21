
package application;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        List<Product> prd = new ArrayList<>();
        
        System.out.print("Enter the number of products: ");
        int n = sc.nextInt();
        
        System.out.println();
        
        for (int i = 1; i <= n; i++) {
            System.out.println("Product #" + i + " data: ");
            System.out.print("Common, used or imported (c/u/i)? ");
            char c = sc.next().charAt(0);
            sc.nextLine();
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Price: ");
            double price = sc.nextDouble();
            
            switch(c){
                case 'c':
                    prd.add(new Product(name, price));
                break;
                case 'u':
                    System.out.print("Manufacture date (DD/MM/YYYY): ");
                    LocalDate date = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                    
                    prd.add(new UsedProduct(date, name, price));
                break;
                case 'i':
                    System.out.print("Customs fee: ");
                    double fee = sc.nextDouble();
                    
                    prd.add(new ImportedProduct(fee, name, price));
                break;
                default:
                    System.out.println("ERROR!!!!!!!");
                break;
            } 
        }
        
        System.out.println();
        
        System.out.println("PRICE TAGS: ");
        for (Product p : prd) {
            System.out.println(p.priceTag());
        }
        
        sc.close();
    }
}
