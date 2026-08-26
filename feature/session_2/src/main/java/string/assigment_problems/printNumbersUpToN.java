package feature.session_2.src.main.java.string.assigment_problems;
import java.util.Scanner;

public class printNumbersUpToN {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter n: ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.println(i);
        }

        sc.close();
    }
}