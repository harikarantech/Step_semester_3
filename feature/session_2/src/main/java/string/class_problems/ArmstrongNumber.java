package feature.session_2.src.main.java.string.class_problems;
import java.util.Scanner;

public class ArmstrongNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int number = sc.nextInt();
        int origNumber = number;
        int sum = 0;

        while (number > 0) {
            int digit = number % 10;
            sum = sum + (digit * digit * digit);
            number = number / 10;
        }

        if (sum == origNumber) {
            System.out.println("Is the number " + origNumber + " an Armstrong number? Yes");
        } else {
            System.out.println("Is the number " + origNumber + " an Armstrong number? No");
        }

        sc.close();
    }
}