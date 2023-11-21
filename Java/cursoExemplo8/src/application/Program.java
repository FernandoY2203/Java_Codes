
package application;

import entities.Circle;
import entities.Rectangle;
import entities.Shape;
import entities.enums.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        List<Shape> form = new ArrayList<>();
        
        System.out.print("Enter the number of shapes: ");
        int n = sc.nextInt();
        
        System.out.println();
        
        for (int i = 1; i <= n; i++) {
            System.out.println("Shape #" + i + " data:" );
            System.out.print("Rectangle or Circle (r/c)? ");
            char shape = sc.next().charAt(0);
            sc.nextLine();
            System.out.print("Color (BLACK/BLUE/RED): ");
            Color c = Color.valueOf(sc.nextLine());
            
            switch(shape){
                case 'r':
                    System.out.print("Width: ");
                    double w = sc.nextDouble();
                    System.out.print("Height: ");
                    double h = sc.nextDouble();
                    
                    form.add(new Rectangle(w, h, c));
                break;
                case 'c':
                    System.out.print("Radius: ");
                    double r = sc.nextDouble();
                    
                    form.add(new Circle(r, c));
                break;
            }
        }
        
        System.out.println();
        
        System.out.println("SHAPE AREAS:");
        for (Shape s : form) {
            System.out.println(String.format("%.2f", s.area()));
        }
        
        sc.close();
    }
}
