package main.java.string.Assignment_Problems;

import java.util.*;

public class HostelElectricityBill {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            int units = sc.nextInt();

            double bill;

            if (type.equals("SINGLE")) {
                bill = units * 8;
            } else if (type.equals("SHARED")) {
                int occupants = sc.nextInt();
                bill = (units * 6.0) / occupants;
            } else {
                bill = units * 10 + 200;
            }

            total += bill;

            System.out.printf("%s: %.2f%n", type, bill);
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}