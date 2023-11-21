
package application;

import entities.Account;
import entities.BusinessAccount;
import entities.SavingsAccount;

public class Program {
    public static void main(String[] args) {
        
        Account acc = new Account(1001, "Alex", 0.0);
        BusinessAccount bacc = new BusinessAccount(500.0, 1002, "Maria", 500.0);
        
        // Upcasting
        Account acc1 = bacc;
        Account acc2 = new BusinessAccount(200.0, 1003, "Bob", 0.0);
        Account acc3 = new SavingsAccount(0.01, 1004, "Anna", 0.0);
        
        // Downcasting
        BusinessAccount acc4 = (BusinessAccount) acc2;
        acc4.loan(100.0);
        
        // BusinessAccount acc5 = (BusinessAccount)acc3;
        if (acc3 instanceof BusinessAccount) { // instanceof Permite testar o tipo especifico de uma Classe, Subclasse ou Interface
            BusinessAccount acc5 = (BusinessAccount) acc3;
            acc5.loan(200.0);
            System.out.println("Loan!");
        }
        
        if (acc3 instanceof SavingsAccount) {
            SavingsAccount acc5 = (SavingsAccount) acc3;
            acc5.updateBalance();
            System.out.println("Update!");
        }
        
        bacc.withdraw(50.0);
        System.out.println(bacc.getBalance());
    }
}
