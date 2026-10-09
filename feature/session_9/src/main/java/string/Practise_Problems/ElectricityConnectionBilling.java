package main.java.string.Practise_Problems;
import java.util.*;

abstract class Connection {
    double units;

    Connection(double units) {
        this.units = units;
    }

    abstract double bill();
}

class Home extends Connection {
    Home(double units) {
        super(units);
    }

    double bill() {
        return Math.min(units, 100) * 5
             + Math.max(0, units - 100) * 7;
    }
}

class Shop extends Connection {
    Shop(double units) {
        super(units);
    }

    double bill() {
        return units * 8 + 100;
    }
}

class Factory extends Connection {
    Factory(double units) {
        super(units);
    }

    double bill() {
        return Math.max(units * 6, 1000);
    }
}

public class ElectricityConnectionBilling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        List<Connection> list = new ArrayList<>();
        List<String> types = new ArrayList<>();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String[] s = sc.nextLine().trim().split("\\\\s+");
            double units = Double.parseDouble(s[1]);

            types.add(s[0]);

            switch (s[0]) {
                case "HOME":
                    list.add(new Home(units));
                    break;
                case "SHOP":
                    list.add(new Shop(units));
                    break;
                case "FACTORY":
                    list.add(new Factory(units));
                    break;
            }
        }

        for (int i = 0; i < list.size(); i++) {
            double amount = list.get(i).bill();
            System.out.printf("%s: %.2f%n",
                types.get(i), amount);
            total += amount;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
