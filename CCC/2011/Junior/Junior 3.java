import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T1 = sc.nextInt();
        int T2 = sc.nextInt();
        int counter = 2;
        int nextT = 0;

        do {
            nextT = T1 - T2;
            T1 = T2;
            T2 = nextT;
            counter++;
            if (T2 > T1) {
                break;
            }
        } while(T2 <= T1);
        System.out.println(counter);
    }
}
