import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        String word = "";
        for (int i = 0; i < t; i++) {
            word = sc.nextLine();
            word = word.replaceAll("[^a-zA-Z0-9]", "");
            while (word.length() != 10) {
                word = word.substring(0, word.length()-1);
                if (word.length() == 10) {
                    break;
                }
            }
            StringBuilder sb = new StringBuilder(word);
            for (int j = 0; j < 10; j++) {
                if (sb.charAt(j) == 'A' || sb.charAt(j) == 'B' || sb.charAt(j) == 'C') {
                    sb.setCharAt(j, '2');
                } else if (sb.charAt(j) == 'D' || sb.charAt(j) == 'E' || sb.charAt(j) == 'F') {
                    sb.setCharAt(j, '3');
                } else if (sb.charAt(j) == 'G' || sb.charAt(j) == 'H' || sb.charAt(j) == 'I') {
                    sb.setCharAt(j, '4');
                } else if (sb.charAt(j) == 'J' || sb.charAt(j) == 'K' || sb.charAt(j) == 'L') {
                    sb.setCharAt(j, '5');
                } else if (sb.charAt(j) == 'M' || sb.charAt(j) == 'N' || sb.charAt(j) == 'O') {
                    sb.setCharAt(j, '6');
                } else if (sb.charAt(j) == 'P' || sb.charAt(j) == 'Q' || sb.charAt(j) == 'R' || sb.charAt(j) == 'S') {
                    sb.setCharAt(j, '7');
                } else if (sb.charAt(j) == 'T' || sb.charAt(j) == 'U' || sb.charAt(j) == 'V') {
                    sb.setCharAt(j, '8');
                } else if (sb.charAt(j) == 'W' || sb.charAt(j) == 'X' || sb.charAt(j) == 'Y' || sb.charAt(j) == 'Z') {
                    sb.setCharAt(j, '9');
                }
            }
            word = sb.toString();
            word = word.substring(0, 3) + "-" + word.substring(3, 6) + "-" + word.substring(6, 10);
            System.out.println(word);
        }
    }
}
