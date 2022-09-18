import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int P = sc.nextInt();
        int N = sc.nextInt();
        int R = sc.nextInt();
        int counter = 0;
        int multiplier = R;
        int replaceN = N;
        while (N <= P) {
            N += (replaceN*multiplier);
            multiplier = (multiplier*R);
            counter++;
            if (N > P) {
                break;
            }
        }
        System.out.println(counter);
    }
}
