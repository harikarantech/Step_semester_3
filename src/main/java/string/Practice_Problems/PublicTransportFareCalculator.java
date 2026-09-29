package main.java.string.Practice_Problems;

import java.util.*;

public class PublicTransportFareCalculator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            double distance = sc.nextDouble();

            double fare;

            if (type.equals("BUS")) {

                fare = 2 + (0.10 * distance);

                if (fare > 10) {
                    fare = 10;
                }

            } 
            else if (type.equals("TRAIN")) {

                fare = 3 + (0.15 * distance);

            } 
            else {

                double peakHourFactor = sc.nextDouble();

                fare = (1.50 + (0.20 * distance))
                        * peakHourFactor;
            }

            total += fare;

            System.out.printf("%s: %.2f%n", type, fare);
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}
