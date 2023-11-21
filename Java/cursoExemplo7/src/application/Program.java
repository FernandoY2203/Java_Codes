
package application;

import entities.Employee;
import entities.OutsourcedEmployee;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Employee> emp = new ArrayList<>();
        
        System.out.print("Enter the number of employees: ");
        int n = sc.nextInt();
        
        System.out.println();
        
        for (int i = 1; i <= n; i++) {
            System.out.println("Employee #" + i + " data:");
            System.out.print("Outsourced (y/n)? ");
            char outS = sc.next().charAt(0);
            sc.nextLine();
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Hours: ");
            int hours = sc.nextInt();
            System.out.print("Value per hour: ");
            double vPHours = sc.nextDouble();
            
            if(outS == 'y' || outS == 'Y'){
                System.out.print("Additional charge: ");
                double aCharge = sc.nextDouble();
                
                emp.add(new OutsourcedEmployee(aCharge, name, hours, vPHours));
            }
            else{
                emp.add(new Employee(name, hours, vPHours));
            }
        }
        
        System.out.println("");
        
        System.out.println("PAYMENTS: ");
        for (Employee e : emp) {
            System.out.println(e);
        }
        
        sc.close();
    }
}
