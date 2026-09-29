package main.java.string.Practice_Problems;

import java.util.*;

public class DeliveryFeeCalculator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            double weight = sc.nextDouble();
            double distance = sc.nextDouble();

            double fee;

            if (type.equals("STANDARD")) {

                fee = 5 + (0.50 * weight) + (0.10 * distance);

            } 
            else if (type.equals("EXPRESS")) {

                fee = 15 + (1.00 * weight) + (0.20 * distance);

            } 
            else {

                double customsFee = sc.nextDouble();

                fee = 25 + (2.00 * weight)
                        + (0.50 * distance)
                        + customsFee;
            }

            total += fee;

            System.out.printf("%s: %.2f%n", type, fee);
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}