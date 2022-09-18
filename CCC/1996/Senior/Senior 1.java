import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int sum = 0;
        
        for (int i = 0; i < N; i++) {
            
            int num = sc.nextInt();
            for (int j = 1; j <= (num/2); j++) {
                if (num % j == 0) {
                    sum += j;
                }
            }
            if (sum < num) {
                System.out.println(num + " is a deficient number.");
            } else if (sum == num) {
                System.out.println(num + " is a perfect number.");
            } else if (sum > num) {
                System.out.println(num + " is an abundant number.");
            }
            
            sum = 0;
        }
    }
}
