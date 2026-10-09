package main.java.string.Practise_Problems;
import java.util.*;

abstract class Booking {
    static final double BOOKING_FEE = 50.0;
    double distance;

    Booking(double distance) {
        this.distance = distance;
    }

    abstract double baseFare();

    double totalFare() {
        return baseFare() + BOOKING_FEE;
    }
}

class Bus extends Booking {
    Bus(double distance) {
        super(distance);
    }

    double baseFare() {
        return distance * 2;
    }
}

class Train extends Booking {
    Train(double distance) {
        super(distance);
    }

    double baseFare() {
        return distance * 1.5;
    }
}

class Flight extends Booking {
    Flight(double distance) {
        super(distance);
    }

    double baseFare() {
        return 2500 + distance * 4;
    }
}

public class TravelBooking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        List<Booking> bookings = new ArrayList<>();
        List<String> modes = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] s = sc.nextLine().trim().split("\\\\s+");
            double distance = Double.parseDouble(s[1]);

            modes.add(s[0]);

            switch (s[0]) {
                case "BUS":
                    bookings.add(new Bus(distance));
                    break;
                case "TRAIN":
                    bookings.add(new Train(distance));
                    break;
                case "FLIGHT":
                    bookings.add(new Flight(distance));
                    break;
            }
        }

        for (int i = 0; i < bookings.size(); i++) {
            System.out.printf("%s: %.2f%n",
                modes.get(i), bookings.get(i).totalFare());
        }

        sc.close();
    }
}
