import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int k = sc.nextInt();
        int sum = 0;
        for (int i = 0; i < k+1; i++) {
            sum += N;
            N = N*10;
        }
        System.out.println(sum);
    }
}
