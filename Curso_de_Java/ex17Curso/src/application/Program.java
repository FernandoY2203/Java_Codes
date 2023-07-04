package application;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Program {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Set<Integer> a = new HashSet<>();
        Set<Integer> b = new HashSet<>();
        Set<Integer> c = new HashSet<>();

        System.out.print("How many students for couse A? ");
        int nA = sc.nextInt();

        for (int i = 0; i < nA; i++) {
            int aux = sc.nextInt();

            a.add(aux);
        }

        System.out.println();

        System.out.print("How many students for couse B? ");
        int nB = sc.nextInt();

        for (int i = 0; i < nB; i++) {
            int aux = sc.nextInt();

            a.add(aux);
        }

        System.out.println();

        System.out.print("How many students for couse C? ");
        int nC = sc.nextInt();

        for (int i = 0; i < nC; i++) {
            int aux = sc.nextInt();

            a.add(aux);
        }

        System.out.println();

        Set<Integer> total = new HashSet<>(a);

        total.addAll(b);
        total.addAll(c);

        System.out.println("Total Students: " + total.size());

        sc.close();
    }
}


