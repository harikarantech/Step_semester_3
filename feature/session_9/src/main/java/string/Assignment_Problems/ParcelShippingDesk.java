package main.java.string.Assignment_Problems;
import java.util.*;

interface Insurable {
    double insurance(double declaredValue);
}

abstract class Parcel {
    double weight, declaredValue;

    Parcel(double weight, double declaredValue) {
        this.weight = weight;
        this.declaredValue = declaredValue;
    }

    abstract double charge();

    double insurance() {
        if (this instanceof Insurable) {
            return ((Insurable) this).insurance(declaredValue);
        }
        return 0;
    }

    double total() {
        return charge() + insurance();
    }
}

class Standard extends Parcel {
    Standard(double w, double v) {
        super(w, v);
    }

    double charge() {
        return 40 + 10 * weight;
    }
}

class Express extends Parcel implements Insurable {
    Express(double w, double v) {
        super(w, v);
    }

    double charge() {
        return 80 + 15 * weight;
    }

    public double insurance(double value) {
        return value * 0.02;
    }
}

class Fragile extends Parcel implements Insurable {
    Fragile(double w, double v) {
        super(w, v);
    }

    double charge() {
        return 40 + 10 * weight + 50;
    }

    public double insurance(double value) {
        return value * 0.02;
    }
}

public class ParcelShippingDesk {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        List<Parcel> parcels = new ArrayList<>();
        List<String> types = new ArrayList<>();
        double grandTotal = 0;

        for (int i = 0; i < n; i++) {
            String[] s = sc.nextLine().trim().split("\\\\s+");
            double weight = Double.parseDouble(s[1]);
            double value = Double.parseDouble(s[2]);

            types.add(s[0]);

            switch (s[0]) {
                case "STANDARD":
                    parcels.add(new Standard(weight, value));
                    break;
                case "EXPRESS":
                    parcels.add(new Express(weight, value));
                    break;
                case "FRAGILE":
                    parcels.add(new Fragile(weight, value));
                    break;
            }
        }

        for (int i = 0; i < parcels.size(); i++) {
            Parcel p = parcels.get(i);
            double charge = p.charge();
            double insurance = p.insurance();
            double total = p.total();

            System.out.printf(
                "%s: Charge=%.2f Insurance=%.2f Total=%.2f%n",
                types.get(i), charge, insurance, total);

            grandTotal += total;
        }

        System.out.printf("Grand Total: %.2f%n", grandTotal);
        sc.close();
    }
}