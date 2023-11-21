
package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import model.entities.Contract;
import model.entities.Installment;
import model.services.ContractService;
import model.services.PaypalService;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter with the contract data: ");
        System.out.print("Number: ");
        int num = sc.nextInt();
        System.out.print("Date (dd/MM/yyyy): ");
        LocalDate contractDate = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        System.out.print("Contract value: ");
        double contractValue = sc.nextDouble();
        
        Contract ctr = new Contract(num, contractDate, contractValue);
        
        System.out.println();
        
        System.out.print("Enter with the number of installments: ");
        int n = sc.nextInt();
        
        ContractService cs = new ContractService(new PaypalService());
        
        cs.processContract(ctr, n);
        
        System.out.println();
        
        System.out.println("INSTALLMENTS: ");
        for (Installment i : ctr.getInstallments()) {
            System.out.println(i.toString());
        }
        
        sc.close();
    }
}
