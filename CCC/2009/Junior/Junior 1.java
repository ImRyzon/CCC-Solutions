import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] array = new int[3];
        for (int i = 0; i < 3; i++) {
            array[i] = sc.nextInt();
        }
        System.out.println(("The 1-3-sum is " + (91 + (array[0]*1) + (array[1]*3) + (array[2]*1))));

    }
}
