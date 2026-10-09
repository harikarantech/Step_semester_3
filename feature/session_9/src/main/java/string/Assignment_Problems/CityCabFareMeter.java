package main.java.string.Assignment_Problems;
import java.util.*;

interface NightService {
    double nightFare(double fare);
}

abstract class Cab {
    double km;

    Cab(double km) {
        this.km = km;
    }

    abstract double rate();

    double fare() {
        return Math.max(100, km * rate());
    }
}

class Mini extends Cab {
    Mini(double km) {
        super(km);
    }

    double rate() {
        return 10;
    }
}

class Sedan extends Cab implements NightService {
    Sedan(double km) {
        super(km);
    }

    double rate() {
        return 14;
    }

    public double nightFare(double fare) {
        return fare * 1.20;
    }
}

class SUV extends Cab implements NightService {
    SUV(double km) {
        super(km);
    }

    double rate() {
        return 18;
    }

    public double nightFare(double fare) {
        return fare * 1.20;
    }
}

public class CityCabFareMeter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double total = 0;

        for (int i = 0; i < n; i++) {
            String[] s = sc.nextLine().trim().split("\\\\s+");
            String type = s[0];
            double km = Double.parseDouble(s[1]);
            String time = s[2];

            Cab cab;

            switch (type) {
                case "MINI":
                    cab = new Mini(km);
                    break;
                case "SEDAN":
                    cab = new Sedan(km);
                    break;
                case "SUV":
                    cab = new SUV(km);
                    break;
                default:
                    continue;
            }

            if (time.equals("NIGHT")) {
                if (!(cab instanceof NightService)) {
                    System.out.println(
                        "MINI: night service not available");
                    continue;
                }

                cabFareNight(cab);
                double fare = ((NightService) cab)
                    .nightFare(cab.fare());

                System.out.printf("%s: %.2f%n", type, fare);
                total += fare;
            } else {
                double fare = cab.fare();
                System.out.printf("%s: %.2f%n", type, fare);
                total += fare;
            }
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }

    static void cabFareNight(Cab cab) {
        // Night fare is calculated through the NightService interface.
    }
}
