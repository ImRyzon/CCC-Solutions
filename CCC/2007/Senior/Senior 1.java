import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] stringAge = new String[3];
        int[] age = new int[3];
        String line = "";
        
        for (int i = 0; i < n; i++) {
            
            line = sc.nextLine();
            stringAge = line.split(" ");
            
            for (int j = 0; j < 3; j++) {
                age[j] = Integer.parseInt(stringAge[j]);
            }

            if (age[0] < 1989) {
                System.out.println("Yes");
            } else if (age[0] > 1989) {
                System.out.println("No");
            } else if (age[0] == 1989) {
                if (age[1] < 2 || (age[1] == 2 && age[2] <= 27)) {
                    System.out.println("Yes");
                } else {
                    System.out.println("No");
                }
            }

        }
    }
}
