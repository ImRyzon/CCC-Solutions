import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        String[] studentAns = new String[N];
        String[] actualAns = new String[N];
        int counter = 0;
        for (int i = 0; i < N; i++) {
            studentAns[i] = sc.nextLine();
        }
        for (int i = 0; i < N; i++) {
            actualAns[i] = sc.nextLine();
            if (actualAns[i].equals(studentAns[i])) {
                counter++;
            }
        }
        System.out.println(counter);
        sc.close();
    }
}
