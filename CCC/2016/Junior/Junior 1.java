import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int counter = 0;
        for (int i = 0; i < 6; i++) {
            String line = sc.nextLine();
            if (line.equals("W")) {
                counter++;
            }
        }
        
        if (counter == 0) {
            System.out.println(-1);
        } else if (counter == 1 || counter == 2) {
            System.out.println(3);
        } else if (counter == 3 || counter == 4) {
            System.out.println(2);
        } else {
            System.out.println(1);
        }
    } 
}
