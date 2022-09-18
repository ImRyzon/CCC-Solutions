import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();
        int Y = sc.nextInt();
        int counterDivisor = 2;
        int counter = 0;

        for (int i = X; i <= Y; i++) {
            for (int j = 2; j <= i/2; j++) {
                if (i % j == 0) {
                    counterDivisor++;
                }
            }
            if (counterDivisor == 4) {
                counter++;
            }
            counterDivisor = 2;
        }
        System.out.println("The number of RSA numbers between " + X + " and " + Y + " is " + counter);
        sc.close();
    }
}
