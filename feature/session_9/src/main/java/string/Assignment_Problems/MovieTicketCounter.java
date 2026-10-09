package main.java.string.Assignment_Problems;

import java.util.*;

abstract class Ticket {
    static final double FEE = 20.0;
    int count;

    Ticket(int count) {
        this.count = count;
    }

    abstract double price();

    double amount() {
        return count * (price() + FEE);
    }
}

class Regular extends Ticket {
    Regular(int count) {
        super(count);
    }

    double price() {
        return 150;
    }
}

class Premium extends Ticket {
    Premium(int count) {
        super(count);
    }

    double price() {
        return 250;
    }
}

class Recliner extends Ticket {
    Recliner(int count) {
        super(count);
    }

    double price() {
        return 400;
    }
}

public class MovieTicketCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        List<Ticket> tickets = new ArrayList<>();
        List<String> seats = new ArrayList<>();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String[] s = sc.nextLine().trim().split("\\\\s+");
            int count = Integer.parseInt(s[1]);
            seats.add(s[0]);

            switch (s[0]) {
                case "REGULAR":
                    tickets.add(new Regular(count));
                    break;
                case "PREMIUM":
                    tickets.add(new Premium(count));
                    break;
                case "RECLINER":
                    tickets.add(new Recliner(count));
                    break;
            }
        }

        for (int i = 0; i < tickets.size(); i++) {
            double amount = tickets.get(i).amount();
            System.out.printf("%s: %.2f%n",
                seats.get(i), amount);
            total += amount;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}

