
package application;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import model.entities.CarRental;
import model.entities.Vehicle;
import model.services.BrasilTaxService;
import model.services.RentalService;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter with the rent data: ");
        System.out.print("Car model: ");
        String model = sc.nextLine();
        System.out.print("Start time (dd/MM/yyyy hh:mm): ");
        LocalDateTime start = LocalDateTime.parse(sc.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
        System.out.print("Finish time (dd/MM/yyyy hh:mm): ");
        LocalDateTime finish = LocalDateTime.parse(sc.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
        
        CarRental cr = new CarRental(start, finish, new Vehicle(model));
        
        System.out.println();
        
        System.out.print("Enter with the price per hour: ");
        double pricePHour = sc.nextDouble();
        System.out.print("Enter with the price per day: ");
        double pricePDay = sc.nextDouble();
        
        RentalService rs = new RentalService(pricePHour, pricePDay, new BrasilTaxService());
        
        rs.processInvoice(cr);
        
        System.out.println();
        
        System.out.println("INVOICE:");
        System.out.println("Basic payment: " + String.format("%.2f", cr.getInvoice().getBasicPayment()));
        System.out.println("Tax: " + String.format("%.2f", cr.getInvoice().getTax()));
        System.out.println("Total payment: " + String.format("%.2f", cr.getInvoice().getTotalPayment()));
        
        sc.close();
    }
}
