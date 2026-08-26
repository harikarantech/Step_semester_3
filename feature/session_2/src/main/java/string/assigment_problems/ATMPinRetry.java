package feature.session_2.src.main.java.string.assigment_problems;
import java.util.Scanner;

public class ATMPinRetry {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter correct PIN: ");
        String correctPin = sc.nextLine();

        String[] attempts = new String[3];

        for (int i = 0; i < 3; i++) {
            System.out.print("Enter PIN attempt " + (i + 1) + ": ");
            attempts[i] = sc.nextLine();
        }

        int attempt = 0;
        boolean success = false;

        while (attempt < 3 && !success) {
            boolean isCorrect = attempts[attempt].equals(correctPin);

            if (isCorrect) {
                success = true;
                System.out.println("PIN accepted");
            }

            attempt++;
        }

        if (!success) {
            System.out.println("Card blocked – too many incorrect attempts");
        }

        sc.close();
    }
}