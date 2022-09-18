import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        sc.nextLine();
        String line = sc.nextLine();
        int counterA = 0;
        int counterB = 0;
        for (int i = 0; i < V; i++) {
            if (line.charAt(i) == 'A') {
                counterA++;
            } else {
                counterB++;
            }
        }
        if (counterA > counterB) {
            System.out.println("A");
        } else if (counterB > counterA) {
            System.out.println("B");
        } else {
            System.out.println("Tie");
        }
    }
}
