import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int square = 0;
        int cube = 0;
        int counter = 0;
        for (int i = a; i <= b; i++) {
            square = (int) Math.sqrt(i);
            cube = (int) Math.cbrt(i);
            if ((square*square == i) && (cube*cube*cube == i)) {
                counter++;
            }
        }
        System.out.println(counter);
    }
}
