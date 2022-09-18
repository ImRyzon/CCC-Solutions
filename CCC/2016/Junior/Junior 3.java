import java.io.*;
import java.util.*;

public class Main {
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        int length = line.length();
        int length2 = 0;
        String sub = "";
        int counter = 0;
        String reverse = "";
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - i; j++) {
                sub = line.substring(i, length-j);
                reverse = new StringBuilder(sub).reverse().toString();
                if (sub.equals(reverse) && sub.length() > counter) {
                    length2 = sub.length();
                    counter = length2;
                }
                }
        }
        System.out.println(counter);
    }
}
