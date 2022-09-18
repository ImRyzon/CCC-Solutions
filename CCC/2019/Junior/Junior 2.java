import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.nextLine();
        String[] array = new String[2];
        String line = "";
        String ar = "";
        int num2 = 0;
        for (int i = 0; i < num; i++) {
            line = sc.nextLine();
            array = line.split(" ");
            ar = array[0];
            num2 = Integer.parseInt(ar);
            for (int j = 0; j < num2; j++) {
                System.out.print(array[1]);
            }
            System.out.println("\n");
        }
    }
}
