import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] lineArr = line.split("");

        int[] topRow = {1, 2};
        int[] bottomRow = {3, 4};

        for (int i = 0; i < lineArr.length; i++) {

            if (lineArr[i].equals("H")) {
                int temp1 = topRow[0];
                int temp2 = topRow[1];

                topRow[0] = bottomRow[0];
                topRow[1] = bottomRow[1];
                bottomRow[0] = temp1;
                bottomRow[1] = temp2;
            } else {
                int temp1 = topRow[0];
                int temp2 = bottomRow[0];

                topRow[0] = topRow[1];
                bottomRow[0] = bottomRow[1];
                topRow[1] = temp1;
                bottomRow[1] = temp2;

            }
        }

        System.out.println(topRow[0] + " " + topRow[1]);
        System.out.println(bottomRow[0] + " " + bottomRow[1]);
    }
}
