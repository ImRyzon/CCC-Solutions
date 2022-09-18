import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int pointsA = 100;
        int pointsD = 100;
        String roll = "";
        int rollParse = 0;
        String[] arrayStr = new String[2];
        int[] arrayInt = new int[2];
        for (int i = 0; i < n; i++) {
            roll = sc.nextLine();
            arrayStr = roll.split(" ");
            for (int j = 0; j < 2; j++) {
                arrayInt[j] = Integer.parseInt(arrayStr[j]);
            }
            if (arrayInt[0] > arrayInt[1]) {
                pointsD -= arrayInt[0];
            } else if (arrayInt[1] > arrayInt[0]) {
                pointsA -= arrayInt[1];
            }
        }
        
        System.out.println(pointsA);
        System.out.println(pointsD);
    }
}
