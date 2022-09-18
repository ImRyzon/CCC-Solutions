import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int m = sc.nextInt();
        int sum = 0;
        int div = 0;
        boolean isMod = false;
        for (int i = 0; i < m; i++) {
            sum = (m*i)+1;
            div = sum/x;
            if (x*div == sum) {
                isMod = true;
                System.out.println(div);
                break;
            }
        }
        if (isMod == false) {
            System.out.println("No such integer exists.");
        }
    }
}
