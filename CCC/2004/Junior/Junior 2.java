import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();
        int Y = sc.nextInt();
        System.out.println("All positions change in year " + X);

        for (int i = X+1; i <= Y; i++) {
            if ((i - X) % 60 == 0) {
                System.out.println("All positions change in year " + i);
            }
        }
    }
}
