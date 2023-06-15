
package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;
import java.util.Scanner;
import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {
    public static void main(String[] args) {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        
        try{
            System.out.print("Room number: ");
            int roomNum = sc.nextInt();

            System.out.println();

            System.out.print("Check-in date (dd/MM/yyyy): ");
            LocalDate in = LocalDate.parse(sc.next(), fmt);
            System.out.print("Check-out date (dd/MM/yyyy): ");
            LocalDate out = LocalDate.parse(sc.next(), fmt);

            Reservation reserv = new Reservation(roomNum, in, out);
            System.out.println(reserv);

            System.out.println();
            
            System.out.println("Enter data to update the reservation: ");
            System.out.print("Check-in date (dd/MM/yyyy): ");
            in = LocalDate.parse(sc.next(), fmt);
            System.out.print("Check-out date (dd/MM/yyyy): ");
            out = LocalDate.parse(sc.next(), fmt);
            reserv.updateDates(in, out);
            System.out.println(reserv);
        }
        catch(DateTimeParseException e){
            System.out.println("Invalid date format");
        }
        catch(DomainException e){
            System.out.println("Error in reservation: " + e.getMessage());
        }
        catch(RuntimeException e){
            System.out.println("Unexpected Error");
        }
    }
    
}
