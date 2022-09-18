import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line  = sc.nextLine();
        int index = 0;
        int counterHappy = 0;
        int counterSad = 0;
        
        for (int i = 0; i < line.length(); i++) {
            index = line.indexOf(":-)");
            
            if (index == -1) {
                break;
            } else {
                line = line.substring(0, index) + line.substring(index + 3, line.length());
                counterHappy++;
            }
        }
        
        for (int i = 0; i < line.length(); i++) {
            index = line.indexOf(":-(");
            
            if (index == -1) {
                break;
            } else {
            	line = line.substring(0, index) + line.substring(index + 3, line.length());
                counterSad++;
            }
        }
        
        if (counterHappy == 0 && counterSad == 0) {
            System.out.println("none");
        } else if (counterHappy == counterSad) {
            System.out.println("unsure");
        } else if (counterHappy > counterSad) {
            System.out.println("happy");
        } else {
            System.out.println("sad");
        }
    }
}
