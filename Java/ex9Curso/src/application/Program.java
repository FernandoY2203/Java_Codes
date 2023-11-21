
package application;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        System.out.print("Enter departament's name: ");
        String depName = sc.nextLine();
        
        System.out.println();
        
        System.out.println("Enter worker data:");
        System.out.print("Name: ");
        String wName = sc.nextLine();
        System.out.print("Level: ");
        WorkerLevel wLevel = WorkerLevel.valueOf(sc.nextLine());
        System.out.print("Base salary: ");
        double baseSalary = sc.nextDouble();
        
        Worker worker = new Worker(wName, wLevel, baseSalary, new Department(depName));
        
        System.out.println();
        
        System.out.print("How many contracts to this worker? ");
        int numContracts = sc.nextInt();
        
        System.out.println();
        
        for(int i = 1; i <= numContracts; i++){
            System.out.println("Enter contract #" + i + " data: ");
            System.out.print("Date (DD/MM/YYYY): ");
            LocalDate date = LocalDate.parse(sc.next(), fmt);
            System.out.print("Value per hour: ");
            double valuePHour = sc.nextDouble();
            System.out.print("Duration (hours): ");
            int hours = sc.nextInt();
            
            worker.addContract(new HourContract(date, valuePHour, hours));
        }
        
        System.out.println();
        
        System.out.print("Enter month and year to calculate income (MM/YYYY): ");
        String monthAndYear = sc.next();
        int month = Integer.parseInt(monthAndYear.substring(0, 2));
        int year = Integer.parseInt(monthAndYear.substring(3));
        
        System.out.println("Name: " + worker.getName() + "\n" +
                           "Department: " + worker.getDepartment().getName() + "\n" +
                           "Income for " + monthAndYear + ": " + String.format("%.2f", worker.income(year, month)));
        
        sc.close();
    } 
}
