
package application;

import java.util.Locale;
import java.util.Scanner;
import model.entities.Account;
import model.exceptions.BusinessException;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter account data: ");
        System.out.print("Number: ");
        int num = sc.nextInt();
        System.out.print("Holder: ");
        sc.next();
        String holder = sc.nextLine();
        System.out.print("Initial balance: ");
        double initBalance = sc.nextDouble();
        System.out.print("Withdraw limit: ");
        double withLimit = sc.nextDouble();

        Account ac = new Account(num, holder, initBalance, withLimit);

        System.out.println();
        
        System.out.print("Enter amount for withdraw: ");
        double amount = sc.nextDouble();
        
        try{
            ac.withdraw(amount);
            
            System.out.println("New balance: " + String.format(("%.2f"), ac.getBalance()));
        }
        catch(BusinessException e){
            System.out.println("Withdraw error: " + e.getMessage());
        }
        
        sc.close();
    }
}
