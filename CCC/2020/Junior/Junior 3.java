import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        String line = "";
        String[] array = new String[2];
        int[] x = new int[N];
        int[] y = new int[N];
        int parse = 0;
        for (int i = 0; i < N; i++) {
            line = sc.nextLine();
            array = line.split(",");
            parse = Integer.parseInt(array[0]);
            x[i] = parse;
            parse = Integer.parseInt(array[1]);
            y[i] = parse;
        }
        int xBiggest = 0;
        int yBiggest = 0;
        int xSmallest = x[0];
        int ySmallest = y[0];
        for (int i = 0; i < x.length; i++) {
            if (x[i] > xBiggest) {
                xBiggest = x[i];
            }
        }
        for (int i = 0; i < y.length; i++) {
            if (y[i] > yBiggest) {
                yBiggest = y[i];
            }
        }
        for (int i = 0; i < x.length; i++) {
            if (x[i] < xSmallest) {
                xSmallest = x[i];
            }
        }
        for (int i = 0; i < y.length; i++) {
            if (y[i] < ySmallest) {
                ySmallest = y[i];
            }
        }
        System.out.println((xSmallest - 1) + "," + (ySmallest - 1));
        System.out.println((xBiggest + 1) + "," + (yBiggest + 1));
    }
}
